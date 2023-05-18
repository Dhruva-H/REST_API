package com.example.demo;

import java.util.Arrays;

public class Words {
	private String[] data;

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	public Words(String[] data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "Words [data=" + Arrays.toString(data) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(data);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Words other = (Words) obj;
		return Arrays.equals(data, other.data);
	}
}
