package icu.syra_ti.hello_umiusi;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.lib.ProgressMonitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UmiusiInstaller {
    private String dir = System.getProperty("user.dir") + "/UmiusiCraft";
    public UmiusiInstaller(){
    }
    public void repoClone(ProgressMonitor pm) throws GitAPIException, IOException {
        Path path = Paths.get(this.dir);
        if (Files.exists(path)) {
            File directory = new File(this.dir);
            FileUtils.deleteDirectory(directory);
        }
        CloneCommand cloneCommand = Git.cloneRepository()
                .setURI(UmiusiUtil.getConfig("repo")) // 远程仓库地址
                .setDirectory(new File(this.dir)); // 本地存储路径
        cloneCommand.setProgressMonitor(pm);
        cloneCommand.call();
    }

    public void repoPull(ProgressMonitor pm){
        try {
            Path path = Paths.get(this.dir);
            if (!Files.exists(path)) {
                this.repoClone(pm);
            }
            Git git = Git.open(new File(this.dir));
            PullCommand pullCommand = git.pull();
            pullCommand.setProgressMonitor(pm);
            PullResult pullResult = pullCommand.call();
            if (pullResult.isSuccessful()) {
                System.out.println("拉取完成");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
