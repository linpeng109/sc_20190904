package com.cn.ftp;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.ftpserver.ftplet.*;

import java.io.IOException;

@Log4j2
public class MyFtpLet extends DefaultFtplet {
    @Override
    public FtpletResult onLogin(FtpSession session, FtpRequest request) throws FtpException, IOException {
        String absolutePath = session.getFileSystemView().getHomeDirectory().getAbsolutePath();
        log.debug(absolutePath);
        String filename = request.getArgument();
        log.debug(filename);
        String homeDirectory = session.getUser().getHomeDirectory();
        log.debug(homeDirectory);
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
