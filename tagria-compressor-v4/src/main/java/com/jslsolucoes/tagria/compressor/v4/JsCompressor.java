package com.jslsolucoes.tagria.compressor.v4;

import com.google.javascript.jscomp.CompilationLevel;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.CompilerOptions.LanguageMode;
import com.google.javascript.jscomp.SourceFile;

public class JsCompressor {

    
    private JsCompressor() {
	
    }
    
    public static JsCompressor newCompressor() {
	return new JsCompressor();
    }
    
    public String compress(String jsCode) {
	Compiler compiler = new Compiler();
	CompilerOptions options = new CompilerOptions();
	options.setLanguageIn(LanguageMode.ECMASCRIPT_2019);
	options.setEmitUseStrict(false);
	options.setStrictModeInput(false);
	CompilationLevel.SIMPLE_OPTIMIZATIONS.setOptionsForCompilationLevel(options);
	SourceFile input = SourceFile.fromCode("input.js", jsCode);
	compiler.compile(SourceFile.fromCode("output.js", ""), input, options);
	return compiler.toSource();
    }
}
