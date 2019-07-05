package com.redefine.richtext.filter;

import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

/**
 * Created by liwenbo on 2018/3/9.
 */

public class NewLineFilter implements InputFilter {
    private final char[] filterChars;

    public static NewLineFilter newlineCharFilter() {
        return new NewLineFilter(new char[]{'\n'});
    }


    private NewLineFilter(char[] filterChars) {
        this.filterChars = filterChars == null ? new char[0] : filterChars;
    }

    /**
     * @param source 输入的文字
     * @param start  输入-0，删除-0
     * @param end    输入-文字的长度，删除-0
     * @param dest   原先显示的内容
     * @param dstart 输入-原光标位置，删除-光标删除结束位置
     * @param dend   输入-原光标位置，删除-光标删除开始位置
     * @return null表示原始输入，""表示不接受输入，其他字符串表示变化值
     */
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

        if (needFilter(source)) {
            SpannableStringBuilder builder = new SpannableStringBuilder();
            int abStart = start;
            for (int i = start; i < end; i++) {
                if (isFilterChar(source.charAt(i))) {
                    if (i != abStart) {
                        builder.append(source.subSequence(abStart, i));
                    }
                    abStart = i + 1;
                }
            }

            if (abStart < end) {
                builder.append(source.subSequence(abStart, end));
            }

            return builder;
        }

        return null;
    }

    private boolean needFilter(CharSequence source) {
        String s = source.toString();
        for (char filterChar : filterChars) {
            if (s.indexOf(filterChar) >= 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isFilterChar(char c) {
        for (char filterChar : filterChars) {
            if (filterChar == c) {
                return true;
            }
        }
        return false;
    }
}
