/*
 * JEF - Copyright 2009-2010 Jiyi (mr.jiyi@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.geequery.tools.string;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

import com.github.geequery.tools.ArrayUtils;

public class CharsetName {
	static final String[] charsets=new String[]{
		"Big5",
		"Big5-HKSCS",
		"EUC-JP",
		"EUC-KR",
		"GB18030",
		"GB2312",
		"GBK",
		"IBM-Thai",
		"IBM00858",
		"IBM01140",
		"IBM01141",
		"IBM01142",
		"IBM01143",
		"IBM01144",
		"IBM01145",
		"IBM01146",
		"IBM01147",
		"IBM01148",
		"IBM01149",
		"IBM037",
		"IBM1026",
		"IBM1047",
		"IBM273",
		"IBM277",
		"IBM278",
		"IBM280",
		"IBM284",
		"IBM285",
		"IBM297",
		"IBM420",
		"IBM424",
		"IBM437",
		"IBM500",
		"IBM775",
		"IBM850",
		"IBM852",
		"IBM855",
		"IBM857",
		"IBM860",
		"IBM861",
		"IBM862",
		"IBM863",
		"IBM864",
		"IBM865",
		"IBM866",
		"IBM868",
		"IBM869",
		"IBM870",
		"IBM871",
		"IBM918",
		"ISO-2022-CN",
		"ISO-2022-JP",
		"ISO-2022-JP-2",
		"ISO-2022-KR",
		"ISO-8859-1",
		"ISO-8859-13",
		"ISO-8859-15",
		"ISO-8859-2",
		"ISO-8859-3",
		"ISO-8859-4",
		"ISO-8859-5",
		"ISO-8859-6",
		"ISO-8859-7",
		"ISO-8859-8",
		"ISO-8859-9",
		"JIS_X0201",
		"JIS_X0212-1990",
		"KOI8-R",
		"KOI8-U",
		"Shift_JIS",
		"TIS-620",
		"US-ASCII",
		"UTF-16",
		"UTF-16BE",
		"UTF-16LE",
		"UTF-32",
		"UTF-32BE",
		"UTF-32LE",
		"UTF-8",
		"windows-1250",
		"windows-1251",
		"windows-1252",
		"windows-1253",
		"windows-1254",
		"windows-1255",
		"windows-1256",
		"windows-1257",
		"windows-1258",
		"windows-31j",
		"x-Big5-Solaris",
		"x-euc-jp-linux",
		"x-EUC-TW",
		"x-eucJP-Open",
		"x-IBM1006",
		"x-IBM1025",
		"x-IBM1046",
		"x-IBM1097",
		"x-IBM1098",
		"x-IBM1112",
		"x-IBM1122",
		"x-IBM1123",
		"x-IBM1124",
		"x-IBM1381",
		"x-IBM1383",
		"x-IBM33722",
		"x-IBM737",
		"x-IBM834",
		"x-IBM856",
		"x-IBM874",
		"x-IBM875",
		"x-IBM921",
		"x-IBM922",
		"x-IBM930",
		"x-IBM933",
		"x-IBM935",
		"x-IBM937",
		"x-IBM939",
		"x-IBM942",
		"x-IBM942C",
		"x-IBM943",
		"x-IBM943C",
		"x-IBM948",
		"x-IBM949",
		"x-IBM949C",
		"x-IBM950",
		"x-IBM964",
		"x-IBM970",
		"x-ISCII91",
		"x-ISO-2022-CN-CNS",
		"x-ISO-2022-CN-GB",
		"x-iso-8859-11",
		"x-JIS0208",
		"x-JISAutoDetect",
		"x-Johab",
		"x-MacArabic",
		"x-MacCentralEurope",
		"x-MacCroatian",
		"x-MacCyrillic",
		"x-MacDingbat",
		"x-MacGreek",
		"x-MacHebrew",
		"x-MacIceland",
		"x-MacRoman",
		"x-MacRomania",
		"x-MacSymbol",
		"x-MacThai",
		"x-MacTurkish",
		"x-MacUkraine",
		"x-MS932_0213",
		"x-MS950-HKSCS",
		"x-mswin-936",
		"x-PCK",
		"x-SJIS_0213",
		"x-UTF-16LE-BOM",
		"X-UTF-32BE-BOM",
		"X-UTF-32LE-BOM",
		"x-windows-50220",
		"x-windows-50221",
		"x-windows-874",
		"x-windows-949",
		"x-windows-950",
		"x-windows-iso2022jp"
	};
	public static int getOrder(Charset cs){
		int n=ArrayUtils.indexOf(charsets, cs.name());
		if(ArrayUtils.INDEX_NOT_FOUND==n){
			throw new UnsupportedCharsetException(cs.name());
		}
		return n;
	}
	public static String getName(int index) {
		return charsets[index];
	}
	public static String getStdName(String name){
		try{
			Charset cs=Charset.forName(name);
			return cs.name();
		}catch(UnsupportedCharsetException e){
			return null;
		}
	}
}
