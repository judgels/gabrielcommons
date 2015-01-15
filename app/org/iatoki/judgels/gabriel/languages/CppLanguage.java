package org.iatoki.judgels.gabriel.languages;

import com.google.common.collect.ImmutableList;
import org.iatoki.judgels.gabriel.Language;

import java.util.List;

public final class CppLanguage implements Language {

    private final String compilerPath;

    public CppLanguage(String compilerPath) {
        this.compilerPath = compilerPath;
    }

    @Override
    public String getExecutableFilename(String sourceFilename) {
        return sourceFilename.substring(0, sourceFilename.lastIndexOf('.'));
    }

    @Override
    public List<String> getCompilationCommand(String sourceFilename) {
        String executableFilename = getExecutableFilename(sourceFilename);
        return ImmutableList.of(compilerPath, "-o", executableFilename, sourceFilename);
    }

    @Override
    public List<String> getExecutionCommand(String sourceFilename) {
        String executableFilename = getExecutableFilename(sourceFilename);
        return ImmutableList.of("./" + executableFilename);
    }
}
