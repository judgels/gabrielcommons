package org.iatoki.judgels.gabriel.sandboxes;

import org.apache.commons.io.FileUtils;
import org.iatoki.judgels.gabriel.Sandbox;
import org.iatoki.judgels.gabriel.SandboxProvider;

import java.io.File;
import java.io.IOException;

public class FakeSandboxProvider implements SandboxProvider {

    private final File baseDir;
    private int sandboxId;

    public FakeSandboxProvider(File baseDir) {
        this.baseDir = baseDir;
        this.sandboxId = 0;
    }

    @Override
    public Sandbox newSandbox() {
        sandboxId++;
        File dir = new File(baseDir, "" + sandboxId);

        try {
            FileUtils.forceMkdir(dir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new FakeSandbox(dir);
    }
}
