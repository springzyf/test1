package test.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import test.litener.FileUploadProgressListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CustomerMultipartFile extends CommonsMultipartResolver {
//    private HttpServletRequest request;

//    @Override
//    protected FileUpload newFileUpload(FileItemFactory fileItemFactory) {
//        ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
//        upload.setFileSizeMax(-1);
//        if(request!=null){
//            HttpSession session = request.getSession();
//            FileUploadProgressListener progressListener = new FileUploadProgressListener(session);
//            upload.setProgressListener(progressListener);
//        }
//        return upload;
//    }
//
//    @Override
//    public MultipartHttpServletRequest resolveMultipart(HttpServletRequest request) throws MultipartException {
//        //在当前对象中获取到request
//        this.request = request;
//        return super.resolveMultipart(request);
//    }

    @Override
    protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
        HttpSession session = request.getSession();
        String encoding = determineEncoding(request);
        FileUpload fileUpload = prepareFileUpload(encoding);
        FileUploadProgressListener progressListener = new FileUploadProgressListener(session);
        fileUpload.setProgressListener(progressListener);
        try {
            List<FileItem> items = ((ServletFileUpload) fileUpload).parseRequest(request);
            return parseFileItems(items,encoding);
        } catch (FileUploadException e) {
            throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), e);
        }
    }
}
