package com.example.demo;

import java.util.Objects;

public class Result {
	private double x;
	private double y;
	private double result;
	private operation opVal;
	private enum operation{
		ADD,
		SUB,
		MUL,
		DIV
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public operation getOpVal() {
		return opVal;
	}
	public void setOpVal(operation opVal) {
		this.opVal = opVal;
	}
	public Result(double x, double y, double result, int opVal) {
		this.x = x;
		this.y = y;
		this.result = result;
		if(opVal == 1) {
			this.opVal = operation.ADD;
		}
		if(opVal == 2) {
			this.opVal = operation.SUB;
		}
		if(opVal == 3) {
			this.opVal = operation.MUL;
		}
		if(opVal == 4) {
			this.opVal = operation.DIV;
		}
	}
	public Result() {
		this.x = 0;
		this.y = 0;
		this.result = 0;
		this.opVal = operation.ADD;
	}
	@Override
	public int hashCode() {
		return Objects.hash(opVal, result, x, y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		return opVal == other.opVal && Double.doubleToLongBits(result) == Double.doubleToLongBits(other.result)
				&& Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}
	@Override
	public String toString() {
		return "Result [x=" + x + ", y=" + y + ", result=" + result + ", opVal=" + opVal + "]";
	}
}