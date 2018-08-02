package kr.LaruYan.SerossugiGun;


public class Serossugi {
	
	public static String Serolize(String strInput, String strCharsPerLine, boolean hasSpacesBetweenLines, boolean hasReversed){
		
		int charsPerLine = 7;
		
		try{
			charsPerLine = Integer.parseInt(strCharsPerLine);
		}catch(NumberFormatException nfe){
			return "<잘못된 높이 입니다. Wrong Height Specified>";
		}
		
		return alignText(
				splitText(prepareText(strInput),charsPerLine),
						charsPerLine,hasSpacesBetweenLines,hasReversed);
	}
	
	final static String alignText(String[] strInput,int charsPerLine,boolean isSpaceBetweenChars,boolean isReversed){
		
		String[] alignedText = new String[charsPerLine];
		
		//각 줄이 줄을 가득 채우도록 변환합니다
		for (int currentLine = 0; currentLine<strInput.length;currentLine++){
			while(strInput[currentLine].length()<charsPerLine){
				strInput[currentLine] += "　";
			}
		}
		//각 줄을 빈 문자로 채워둡니다
		for (int currentLine = 0; currentLine<charsPerLine;currentLine++){
			alignedText[currentLine] = "";
		}
		//각 줄의 문자로 각 줄을 채워둡니다.
		for(int currentLine = 0;currentLine<charsPerLine;currentLine++){
			for(int currentChar = 0; currentChar<strInput.length;currentChar++){
				alignedText[currentLine] += strInput[isReversed?currentChar:strInput.length-currentChar-1].charAt(currentLine);
				if(currentChar<strInput.length-1  && isSpaceBetweenChars){
					alignedText[currentLine] += "　";
				}
			}
		}
		String returnString = "";
		for (int currentLine = 0; currentLine<charsPerLine;currentLine++){
			
			//뒤쪽의 쓸데없는 빈 공간을 제거합니다.
			while(alignedText[currentLine].endsWith("　")){
				alignedText[currentLine] = alignedText[currentLine].substring(0,alignedText[currentLine].length()-1);
			}
			
			returnString += alignedText[currentLine];
			returnString += "\n";
		}
		return returnString;
	}
	
	final static String[] splitText(String strInput, int charsPerLine){
		//새 문자열 배열을 만듭니다. 전체 글의 문자 수에 줄당 문자 수를 나눈 값으로.
		String[] splittedText = new String[(strInput.length()/charsPerLine)+1];

		//각 줄에 줄당 문자수 만큼 잘라서 넣어줍니다.
		for(int currentLine = 0; currentLine<splittedText.length ;currentLine++){
			splittedText[currentLine] = strInput.substring(charsPerLine*currentLine,
					charsPerLine*(currentLine+1)>=strInput.length()?strInput.length():charsPerLine*(currentLine+1));
		}
		
		return splittedText;
	}
	
	final static String prepareText(String strInput){
		String strConvert = strInput;
		
		//replace １２３４５６７８９０
		strConvert = strConvert.replace('0', '０');
		strConvert = strConvert.replace('1', '１');
		strConvert = strConvert.replace('2', '２');
		strConvert = strConvert.replace('3', '３');
		strConvert = strConvert.replace('4', '４');
		strConvert = strConvert.replace('5', '５');
		strConvert = strConvert.replace('6', '６');
		strConvert = strConvert.replace('7', '７');
		strConvert = strConvert.replace('8', '８');
		strConvert = strConvert.replace('9', '９');
		
		//replace ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ
		strConvert = strConvert.replace('a', 'ａ');
		strConvert = strConvert.replace('b', 'ｂ');
		strConvert = strConvert.replace('c', 'ｃ');
		strConvert = strConvert.replace('d', 'ｄ');
		strConvert = strConvert.replace('e', 'ｅ');
		strConvert = strConvert.replace('f', 'ｆ');
		strConvert = strConvert.replace('g', 'ｇ');
		strConvert = strConvert.replace('h', 'ｈ');
		strConvert = strConvert.replace('i', 'ｉ');
		strConvert = strConvert.replace('j', 'ｊ');
		strConvert = strConvert.replace('k', 'ｋ');
		strConvert = strConvert.replace('l', 'ｌ');
		strConvert = strConvert.replace('m', 'ｍ');
		strConvert = strConvert.replace('n', 'ｎ');
		strConvert = strConvert.replace('o', 'ｏ');
		strConvert = strConvert.replace('p', 'ｐ');
		strConvert = strConvert.replace('q', 'ｑ');
		strConvert = strConvert.replace('r', 'ｒ');
		strConvert = strConvert.replace('s', 'ｓ');
		strConvert = strConvert.replace('t', 'ｔ');
		strConvert = strConvert.replace('u', 'ｕ');
		strConvert = strConvert.replace('v', 'ｖ');
		strConvert = strConvert.replace('w', 'ｗ');
		strConvert = strConvert.replace('x', 'ｘ');
		strConvert = strConvert.replace('y', 'ｙ');
		strConvert = strConvert.replace('z', 'ｚ');
		
		//replace ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ
		strConvert = strConvert.replace('A', 'Ａ');
		strConvert = strConvert.replace('B', 'Ｂ');
		strConvert = strConvert.replace('C', 'Ｃ');
		strConvert = strConvert.replace('D', 'Ｄ');
		strConvert = strConvert.replace('E', 'Ｅ');
		strConvert = strConvert.replace('F', 'Ｆ');
		strConvert = strConvert.replace('G', 'Ｇ');
		strConvert = strConvert.replace('H', 'Ｈ');
		strConvert = strConvert.replace('I', 'Ｉ');
		strConvert = strConvert.replace('J', 'Ｊ');
		strConvert = strConvert.replace('K', 'Ｋ');
		strConvert = strConvert.replace('L', 'Ｌ');
		strConvert = strConvert.replace('M', 'Ｍ');
		strConvert = strConvert.replace('N', 'Ｎ');
		strConvert = strConvert.replace('O', 'Ｏ');
		strConvert = strConvert.replace('P', 'Ｐ');
		strConvert = strConvert.replace('Q', 'Ｑ');
		strConvert = strConvert.replace('R', 'Ｒ');
		strConvert = strConvert.replace('S', 'Ｓ');
		strConvert = strConvert.replace('T', 'Ｔ');
		strConvert = strConvert.replace('U', 'Ｕ');
		strConvert = strConvert.replace('V', 'Ｖ');
		strConvert = strConvert.replace('W', 'Ｗ');
		strConvert = strConvert.replace('X', 'Ｘ');
		strConvert = strConvert.replace('Y', 'Ｙ');
		strConvert = strConvert.replace('Z', 'Ｚ');
		
		//replace ｀～！＠＃＄％＾＆＊（）－＿＋＝｛｝［］＼｜；：＇＂，．＜＞／？
		strConvert = strConvert.replace('`', '｀');
		strConvert = strConvert.replace('~', '～');
		strConvert = strConvert.replace('!', '！');
		strConvert = strConvert.replace('@', '＠');
		strConvert = strConvert.replace('#', '＃');
		strConvert = strConvert.replace('$', '＄');
		strConvert = strConvert.replace('%', '％');
		strConvert = strConvert.replace('^', '＾');
		strConvert = strConvert.replace('&', '＆');
		strConvert = strConvert.replace('*', '＊');
		strConvert = strConvert.replace('(', '（');
		strConvert = strConvert.replace(')', '）');
		strConvert = strConvert.replace('-', '－');
		strConvert = strConvert.replace('_', '＿');
		strConvert = strConvert.replace('+', '＋');
		strConvert = strConvert.replace('=', '＝');
		strConvert = strConvert.replace('{', '｛');
		strConvert = strConvert.replace('}', '｝');
		strConvert = strConvert.replace('[', '［');
		strConvert = strConvert.replace(']', '］');
		strConvert = strConvert.replace('\\', '＼');
		strConvert = strConvert.replace('|', '｜');
		strConvert = strConvert.replace(';', '；');
		strConvert = strConvert.replace(':', '：');
		strConvert = strConvert.replace('\'', '＇');
		strConvert = strConvert.replace('\"', '＂');
		strConvert = strConvert.replace(',', '，');
		strConvert = strConvert.replace('.', '．');
		strConvert = strConvert.replace('<', '＜');
		strConvert = strConvert.replace('>', '＞');
		strConvert = strConvert.replace('/', '／');
		strConvert = strConvert.replace('?', '？');
		strConvert = strConvert.replace(' ', '　');//spaaaaaaaace!
		
		//no crlf
		strConvert = strConvert.replace('\n', '　');
		strConvert = strConvert.replace('\r', '　');
		
		return strConvert;
	}
}
