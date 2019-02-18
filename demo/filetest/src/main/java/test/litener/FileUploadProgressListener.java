package test.litener;

import org.apache.commons.fileupload.ProgressListener;
import test.model.Progress;

import javax.servlet.http.HttpSession;

public class FileUploadProgressListener implements ProgressListener {

    private HttpSession session;

    public FileUploadProgressListener() {
    }

    public FileUploadProgressListener(HttpSession session) {
        this.session = session;
        Progress progress = new Progress();
        session.setAttribute("fileProgress",progress);
    }

    /**
     *
     * @param nowBytes 目前为止读取文件大小
     * @param sumBytes 总文件大小
     * @param fileNum 第几个文件
     */
    @Override
    public void update(long nowBytes, long sumBytes, int fileNum) {
        Progress progress = (Progress) session.getAttribute("fileProgress");
        progress.setNow(nowBytes);
        progress.setSum(sumBytes);
        progress.setFile(fileNum);
    }
}
