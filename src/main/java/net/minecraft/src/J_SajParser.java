package net.minecraft.src;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public final class J_SajParser {
	public void func_27463_a(Reader var1, J_JsonListener var2) throws IOException, J_InvalidSyntaxException {
		J_PositionTrackingPushbackReader var3 = new J_PositionTrackingPushbackReader(var1);
		char var4 = (char)var3.func_27333_c();
		switch(var4) {
		case '[':
			var3.func_27334_a(var4);
			var2.func_27195_b();
			this.func_27455_a(var3, var2);
			break;
		case '{':
			var3.func_27334_a(var4);
			var2.func_27195_b();
			this.func_27453_b(var3, var2);
			break;
		default:
			throw new J_InvalidSyntaxException("Expected either [ or { but got [" + var4 + "].", var3);
		}

		int var5 = this.func_27448_l(var3);
		if(var5 != -1) {
			throw new J_InvalidSyntaxException("Got unexpected trailing character [" + (char)var5 + "].", var3);
		} else {
			var2.func_27204_c();
		}
	}

	private void func_27455_a(J_PositionTrackingPushbackReader var1, J_JsonListener var2) throws IOException, J_InvalidSyntaxException {
		char var3 = (char)this.func_27448_l(var1);
		if(var3 != 91) {
			throw new J_InvalidSyntaxException("Expected object to start with [ but got [" + var3 + "].", var1);
		} else {
			var2.func_27200_d();
			char var4 = (char)this.func_27448_l(var1);
			var1.func_27334_a(var4);
			if(var4 != 93) {
				this.func_27464_d(var1, var2);
			}

			boolean var5 = false;

			while(!var5) {
				char var6 = (char)this.func_27448_l(var1);
				switch(var6) {
				case ',':
					this.func_27464_d(var1, var2);
					break;
				case ']':
					var5 = true;
					break;
				default:
					throw new J_InvalidSyntaxException("Expected either , or ] but got [" + var6 + "].", var1);
				}
			}

			var2.func_27197_e();
		}
	}

	private void func_27453_b(J_PositionTrackingPushbackReader var1, J_JsonListener var2) throws IOException, J_InvalidSyntaxException {
		char var3 = (char)this.func_27448_l(var1);
		if(var3 != 123) {
			throw new J_InvalidSyntaxException("Expected object to start with { but got [" + var3 + "].", var1);
		} else {
			var2.func_27194_f();
			char var4 = (char)this.func_27448_l(var1);
			var1.func_27334_a(var4);
			if(var4 != 125) {
				this.func_27449_c(var1, var2);
			}

			boolean var5 = false;
			while(!var5) {
				char var6 = (char)this.func_27448_l(var1);
				switch(var6) {
				case ',':
					this.func_27449_c(var1, var2);
					break;
				case '}':
					var5 = true;
					break;
				default:
					throw new J_InvalidSyntaxException("Expected either , or } but got [" + var6 + "].", var1);
				}
			}

			var2.func_27203_g();
		}
	}

	private void func_27449_c(J_PositionTrackingPushbackReader var1, J_JsonListener var2) throws IOException, J_InvalidSyntaxException {
		char var3 = (char)this.func_27448_l(var1);
		if(34 != var3) {
			throw new J_InvalidSyntaxException("Expected object identifier to begin with [\"] but got [" + var3 + "].", var1);
		} else {
			var1.func_27334_a(var3);
			var2.func_27205_a(this.func_27452_i(var1));
			char var4 = (char)this.func_27448_l(var1);
			if(var4 != 58) {
				throw new J_InvalidSyntaxException("Expected object identifier to be followed by : but got [" + var4 + "].", var1);
			} else {
				this.func_27464_d(var1, var2);
				var2.func_27199_h();
			}
		}
	}

	private void func_27464_d(J_PositionTrackingPushbackReader var1, J_JsonListener var2) throws IOException, J_InvalidSyntaxException {
		char var3 = (char)this.func_27448_l(var1);
		switch(var3) {
		case '\"':
			var1.func_27334_a(var3);
			var2.func_27198_c(this.func_27452_i(var1));
			break;
		case '-':
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			var1.func_27334_a(var3);
			var2.func_27201_b(this.func_27459_a(var1));
			break;
		case '[':
			var1.func_27334_a(var3);
			this.func_27455_a(var1, var2);
			break;
		case 'f':
			char[] var6 = new char[4];
			int var7 = var1.func_27336_b(var6);
			if(var7 != 4 || var6[0] != 97 || var6[1] != 108 || var6[2] != 115 || var6[3] != 101) {
				var1.func_27335_a(var6);
				throw new J_InvalidSyntaxException("Expected \'f\' to be followed by [[a, l, s, e]], but got [" + Arrays.toString(var6) + "].", var1);
			}

			var2.func_27193_j();
			break;
		case 'n':
			char[] var8 = new char[3];
			int var9 = var1.func_27336_b(var8);
			if(var9 != 3 || var8[0] != 117 || var8[1] != 108 || var8[2] != 108) {
				var1.func_27335_a(var8);
				throw new J_InvalidSyntaxException("Expected \'n\' to be followed by [[u, l, l]], but got [" + Arrays.toString(var8) + "].", var1);
			}

			var2.func_27202_k();
			break;
		case 't':
			char[] var4 = new char[3];
			int var5 = var1.func_27336_b(var4);
			if(var5 != 3 || var4[0] != 114 || var4[1] != 117 || var4[2] != 101) {
				var1.func_27335_a(var4);
				throw new J_InvalidSyntaxException("Expected \'t\' to be followed by [[r, u, e]], but got [" + Arrays.toString(var4) + "].", var1);
			}

			var2.func_27196_i();
			break;
		case '{':
			var1.func_27334_a(var3);
			this.func_27453_b(var1, var2);
			break;
		default:
			throw new J_InvalidSyntaxException("Invalid character at start of value [" + var3 + "].", var1);
		}

	}

	private String func_27459_a(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
		String var2 = "";
		char var3 = (char)var1.func_27333_c();
		if(45 == var3) {
			var2 = var2 + '-';
		} else {
			var1.func_27334_a(var3);
		}

		var2 = var2 + this.func_27451_b(var1);
		return var2;
	}

	private String func_27451_b(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
		String var2 = "";
		char var3 = (char)var1.func_27333_c();
		if(48 == var3) {
			var2 = var2 + '0';
			var2 = var2 + this.func_27462_f(var1);
			var2 = var2 + this.func_27454_g(var1);
		} else {
			var1.func_27334_a(var3);
			var2 = var2 + this.func_27460_c(var1);
			var2 = var2 + this.func_27456_e(var1);
			var2 = var2 + this.func_27462_f(var1);
			var2 = var2 + this.func_27454_g(var1);
		}

		return var2;
	}

	private char func_27460_c(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
		char var3 = (char)var1.func_27333_c();
		switch(var3) {
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			return var3;
		default:
			throw new J_InvalidSyntaxException("Expected a digit 1 - 9 but got [" + var3 + "].", var1);
		}
	}

	private char func_27458_d(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
		char var3 = (char)var1.func_27333_c();
		switch(var3) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			return var3;
		default:
			throw new J_InvalidSyntaxException("Expected a digit 1 - 9 but got [" + var3 + "].", var1);
		}
	}

	private String func_27456_e(J_PositionTrackingPushbackReader var1) throws IOException {
		String var2 = "";
		boolean var3 = false;

		while(!var3) {
			char var4 = (char)var1.func_27333_c();
			switch(var4) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				var2 = var2 + var4;
				break;
			default:
				var3 = true;
				var1.func_27334_a(var4);
			}
		}

		return var2;
	}

	private String func_27462_f(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
		String var2 = "";
		char var3 = (char)var1.func_27333_c();
		if(var3 == 46) {
			var2 = var2 + '.';
			var2 = var2 + this.func_27458_d(var1);
			var2 = var2 + this.func_27456_e(var1);
		} else {
			var1.func_27334_a(var3);
		}

		return var2;
	}

	private String func_27454_g(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
		String var2 = "";
		char var3 = (char)var1.func_27333_c();
		if(var3 != 46 && var3 != 69) {
			var1.func_27334_a(var3);
		} else {
			var2 = var2 + 'E';
			var2 = var2 + this.func_27461_h(var1);
			var2 = var2 + this.func_27458_d(var1);
			var2 = var2 + this.func_27456_e(var1);
		}

		return var2;
	}

	private String func_27461_h(J_PositionTrackingPushbackReader var1) throws IOException {
		String var2 = "";
		char var3 = (char)var1.func_27333_c();
		if(var3 != 43 && var3 != 45) {
			var1.func_27334_a(var3);
		} else {
			var2 = var2 + var3;
		}

		return var2;
	}

	private String func_27452_i(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
		String var2 = "";
		char var3 = (char)var1.func_27333_c();
		if(34 != var3) {
			throw new J_InvalidSyntaxException("Expected [\"] but got [" + var3 + "].", var1);
		} else {
			boolean var4 = false;

			while(!var4) {
				char var5 = (char)var1.func_27333_c();
				switch(var5) {
				case '\"':
					var4 = true;
					break;
				case '\\':
					char var6 = this.func_27457_j(var1);
					var2 = var2 + var6;
					break;
				default:
					var2 = var2 + var5;
				}
			}

			return var2;
		}
	}

	private char func_27457_j(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
		char var3 = (char)var1.func_27333_c();
		char var2;
		switch(var3) {
		case '\"':
			var2 = 34;
			break;
		case '/':
			var2 = 47;
			break;
		case '\\':
			var2 = 92;
			break;
		case 'b':
			var2 = 8;
			break;
		case 'f':
			var2 = 12;
			break;
		case 'n':
			var2 = 10;
			break;
		case 'r':
			var2 = 13;
			break;
		case 't':
			var2 = 9;
			break;
		case 'u':
			var2 = (char)this.func_27450_k(var1);
			break;
		default:
			throw new J_InvalidSyntaxException("Unrecognised escape character [" + var3 + "].", var1);
		}

		return var2;
	}

	private int func_27450_k(J_PositionTrackingPushbackReader var1) throws IOException, J_InvalidSyntaxException {
		char[] var2 = new char[4];
		int var3 = var1.func_27336_b(var2);
		if(var3 != 4) {
			throw new J_InvalidSyntaxException("Expected a 4 digit hexidecimal number but got only [" + var3 + "], namely [" + String.valueOf(var2, 0, var3) + "].", var1);
		} else {
			try {
				int var4 = Integer.parseInt(String.valueOf(var2), 16);
				return var4;
			} catch (NumberFormatException var6) {
				System.out.println("yee3");
				var1.func_27335_a(var2);
				System.out.println("yee4");
				throw new J_InvalidSyntaxException("Unable to parse [" + String.valueOf(var2) + "] as a hexidecimal number.", var6, var1);
			}
		}
	}

	private int func_27448_l(J_PositionTrackingPushbackReader var1) throws IOException {
		while(true) {
			int var2 = var1.func_27333_c();
			switch(var2) {
				case 9:
				case 10:
				case 13:
				case 32:
					break;
				default:
					return var2;
			}
			
		}
	}
}
