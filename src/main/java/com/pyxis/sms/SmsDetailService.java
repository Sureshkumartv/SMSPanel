package com.pyxis.sms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.pyxis.contacts.Contacts;
import com.pyxis.entities.SmsDraft;

public interface SmsDetailService {

	public SmsDetailsDto saveRecord(SmsDetailsDto smsDetailsDto) throws Exception;

	public Map<String, Object> saveExcelFileDetails(FileUploadCountsDto dto) throws Exception;

	byte[] getImage(Integer imageuploadId) throws IOException;

	Integer saveImageUpload(MultipartFile excelFile, Integer type);

	public FileUploadCountsDto saveGroupSMS(FileUploadCountsDto dto, List<Contacts> contacts);

	SmsDetailsDto saveCustomRecord(SmsDetailsDto smsDetailsDto) throws Exception;

	public List<SmsDraft> fetchSmsDraft();

	public void saveDraft(SmsDraft draft);

	public Map<String, Object> saveCustomFileDetails(MultipartFile excelFile);

	public ArrayList<ArrayList<Object>> previewCustomSms(SmsDetailsDto smsDetailsDto);

}
