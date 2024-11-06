package com.ssafy.sandbox.common.util;

public class PaginationUtil {
	public static Long calculateOffset(Long page, Long pageSize) {
		return (page - 1) * pageSize;
	}

	public static Long calculateTotalPage(Long totalItemCount, Long pageSize) {
		return (totalItemCount + pageSize - 1) / pageSize;
	}
}