package com.cn.ftp;

import lombok.Data;
import org.apache.ftpserver.ftplet.*;

import java.io.IOException;

@Data
public class MyFtpLet extends DefaultFtplet {
    @Override
    public FtpletResult onLogin(FtpSession session, FtpRequest request) throws FtpException, IOException {
//        获取上传文件信息
        String absolutePath = session.getFileSystemView().getHomeDirectory().getAbsolutePath();
        String filename = request.getArgument();
        String homeDirectory = session.getUser().getHomeDirectory();
        
        return super.onLogin(session, request);
    }

    @Override
    public FtpletResult onUploadEnd(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onUploadEnd(session, request);
    }

    @Override
    public FtpletResult onDownloadEnd(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onDownloadEnd(session, request);
    }
}
