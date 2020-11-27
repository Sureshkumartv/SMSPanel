package com.pyxis.sms;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.srisairam.sms.CustomUploadFile;
import org.srisairam.sms.files.CSVFileReader;
import org.srisairam.sms.files.ExcelFileReader;
import org.srisairam.sms.files.ExcelXFileReader;
import org.srisairam.ws.FileProcessServiceProxy;
import org.srisairam.ws.MessageType;
import org.srisairam.ws.SendSmsBean;
import org.srisairam.ws.SmsSendingType;
import org.srisairam.ws.UploadFileResponce;
import org.srisairam.ws.UploadTypes;

import com.pyxis.contacts.Contacts;
import com.pyxis.entities.ImageUpload;
import com.pyxis.entities.SmsDraft;
import com.pyxis.repositories.ImageUploadRepository;
import com.pyxis.repositories.SmsDraftRepository;
import com.pyxis.users.UserToken;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SmsDetailServiceImpl implements SmsDetailService {
	private static Logger logger = LoggerFactory.getLogger(SmsDetailServiceImpl.class);
	@Autowired
	SmsDetailRepository smsDetailRepository;

	@Value("${uploads.images.path}")
	String imageUploadPath;

	@Value("${uploads.videos.path}")
	String videoUploadPath;

	@Value("${smsuploads.path}")
	String smsUploadsPath;

	@Value("${http.ws.panel.url}")
	String panelApiUrl;

	@Autowired
	ImageUploadRepository imageUploadRepository;

	@Autowired
	SmsDraftRepository smsDraftRepository;

	@Override
	public SmsDetailsDto saveRecord(SmsDetailsDto smsDetailsDto) throws Exception {
		Date scheduleTime = null;
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
                if(null != smsDetailsDto.getDate()){
                    try {
                            scheduleTime = format.parse(smsDetailsDto.getDate());
                            System.out.println("ScheduleTime :: ----------------------------------------- "+scheduleTime);
                    } catch (ParseException ex) {
                            ex.printStackTrace();
                    }
                }
		UserToken auth = (UserToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		SmsDetailsDto dto = new SmsDetailsDto();
//		SmsDetails sd = new SmsDetails();
//		sd.setSmsMsisdn(smsDetailsDto.getSmsMsisdn());
//		sd.setSmsMessage(smsDetailsDto.getSmsMessage());
//		sd.setSmsSendingType(2);
//		sd.setSmsSmppId(12);
//		sd.setSmsSendingComplete("N");
//
//		sd.setSmsScheduleDate(scheduleTime);
//		sd.setSmsInsertDate(scheduleTime);
//		sd.setSmsUploadedBy(1646);
//		sd.setSmsStatus("Y");
//		SmsDetails obj = smsDetailRepository.save(sd);
//		if (obj != null) {
//			dto.setStatus("Success");
//		} else {
//			dto.setStatus("Fail");
//		}
//        File file = new File(smsUploadsPath);
//        if(!file.exists()){
//            file.createNewFile();
//        }
		FileProcessServiceProxy proxy = new FileProcessServiceProxy(panelApiUrl);

		SendSmsBean smsObj = new SendSmsBean();
		smsObj.setBasePath(smsUploadsPath);
		smsObj.setMessageType(MessageType.fromString("ENGLISH"));
		
		smsObj.setUploadType(UploadTypes.fromValue(smsDetailsDto.getType().toUpperCase()));
		smsObj.setMobileNumbers(smsDetailsDto.getSmsMsisdn());

		
		Calendar cal = Calendar.getInstance();
		if(null != scheduleTime){
			smsObj.setScheduleDateTime(format.format(scheduleTime));
			cal.setTime(scheduleTime);
			smsObj.setScheduleTime(cal);
		}
		smsObj.setSenderId(smsDetailsDto.getSenderId());
		smsObj.setSmppId(auth.getSmppId());
		//
		smsObj.setSmsSendingType(
				SmsSendingType.fromValue(org.srisairam.enums.SmsSendingType.getType(auth.getSmsSendType()).toString()));
		smsObj.setMessage(smsDetailsDto.getSmsMessage());
        smsObj.setUploadFilePath(smsDetailsDto.getFilepath());
        smsObj.setUploadFilePath(smsDetailsDto.getFilepath());
        smsObj.setMessageType(MessageType.fromValue(org.srisairam.enums.MessageType.getType(smsDetailsDto.getMessageType()).toString()));
		//
		UploadFileResponce response = proxy.processUploadFile(auth.getUsername(), auth.getPassword(), smsObj);
               System.out.println("Response credits ::"+response.getFileCredits());
		// if(response.getFileCredits());

		return dto;
	}

	@Override
	public SmsDetailsDto saveCustomRecord(SmsDetailsDto smsDetailsDto) throws Exception {
		UserToken auth = (UserToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		SmsDetailsDto dto = new SmsDetailsDto();
		SmsDetails sd = new SmsDetails();
//		sd.setSmsMsisdn(smsDetailsDto.getSmsMsisdn());
//		sd.setSmsMessage(smsDetailsDto.getSmsMessage());
//		sd.setSmsSendingType(2);
//		sd.setSmsSmppId(12);
//		sd.setSmsSendingComplete("N");
//		sd.setSmsScheduleDate(new Date());
//		sd.setSmsInsertDate(new Date());
//		sd.setSmsUploadedBy(1646);
//		sd.setSmsStatus("Y");
//		SmsDetails obj = smsDetailRepository.save(sd);
//		if (obj != null) {
//			dto.setStatus("Success");
//		} else {
//			dto.setStatus("Fail");
//		}

		FileProcessServiceProxy proxy = new FileProcessServiceProxy(panelApiUrl);

		SendSmsBean smsObj = new SendSmsBean();
		smsObj.setBasePath(smsDetailsDto.getFilePath());
		smsObj.setMessageType(MessageType.fromString("ENGLISH"));
		smsObj.setUploadType(UploadTypes.fromValue("FILE"));
		smsObj.setMobileNumbers(smsDetailsDto.getMobileColumn());

		// smsObj.setScheduleDateTime(scheduleDateTime);
		// smsObj.setScheduleTime(scheduleTime);
		smsObj.setSenderId(smsDetailsDto.getSenderId());
		smsObj.setSmppId(auth.getSmppId());
		//
		smsObj.setSmsSendingType(
				SmsSendingType.fromValue(org.srisairam.enums.SmsSendingType.getType(auth.getSmsSendType()).toString()));
		smsObj.setMessage(smsDetailsDto.getSmsMessage());
		//
		UploadFileResponce response = proxy.processCustomUploadFile(auth.getUsername(), auth.getPassword(), smsObj);

		// if(response.getFileCredits());

		return dto;
	}

	@Override
	public Map<String, Object> saveExcelFileDetails(FileUploadCountsDto dto) throws Exception {
		UserToken auth = (UserToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> map = new HashMap<>();
		File directory = new File(smsUploadsPath + "temp");
		if (!directory.exists()) {
			directory.mkdir();
		}
		File file = new File(directory, System.currentTimeMillis() + "_" + dto.getUploadedFile().getOriginalFilename());
		System.out.println(file.getPath());
		if (!file.exists()) {
			file.createNewFile();
		}
		dto.getUploadedFile().transferTo(file);
		System.out.println("----------------------------------------------------------------------"+dto.getUploadedFile().getOriginalFilename());
		processUploadedFile(dto, file);
		System.out.println("Total Count final ::"+dto.getTotal());
		map.put("dto", dto );
		map.put("fileName", file.getAbsolutePath() );
		return map;
	}

	private void processUploadedFile(FileUploadCountsDto dto, File baseFile) throws Exception {
		Set<String> validNumbers = new HashSet<>();
		boolean first = true;
		Integer invalidCount = 0;
		Integer totalCount = 0;
		System.out.println("----------------------------------------------------------------------"+dto.getUploadedFile().getOriginalFilename());
		if (dto.getUploadedFile().getOriginalFilename().toLowerCase().endsWith("xls")) {
			ExcelFileReader fileReader = null;
			fileReader = new ExcelFileReader();
			fileReader.openFile(baseFile, false);
			Object elemnts = fileReader.getNextLine(0);
			while (elemnts != null) {
				if (elemnts.toString().trim().length() > 0) {
					totalCount++;
					if (elemnts.toString().trim().length() == 10) {
						validNumbers.add(elemnts.toString());
					} else {
						invalidCount++;
					}
					elemnts = fileReader.getNextLine(0);
					first = false;
				}
			}
		}if (dto.getUploadedFile().getOriginalFilename().toLowerCase().endsWith("xlsx")) {
			ExcelXFileReader fileReader = null;
			fileReader = new ExcelXFileReader();
			fileReader.openFile(baseFile, false);
			Object elemnts = fileReader.getNextLine(0);
			while (elemnts != null) {
				if (elemnts.toString().trim().length() > 0) {
					totalCount++;
					if (elemnts.toString().trim().length() == 10) {
						validNumbers.add(elemnts.toString());
					} else {
						invalidCount++;
					}
					elemnts = fileReader.getNextLine(0);
					first = false;
				}
			}
		} else {
			String seperator = null;
			if (dto.getUploadedFile().getOriginalFilename().toLowerCase().endsWith("csv")) {
				seperator = ",";
			}
			System.out.println("seperator===>" + seperator);
			CSVFileReader fileReader = new CSVFileReader(seperator);
			fileReader.openFile(baseFile, false);
			Object elemnts = fileReader.getNextLine(0);
			while (elemnts != null) {
				if (elemnts.toString().trim().length() > 0) {
					totalCount++;
					if (elemnts.toString().trim().length() == 10) {
						validNumbers.add(elemnts.toString());
					} else {
						invalidCount++;
					}
					elemnts = fileReader.getNextLine(0);
					first = false;
				}
			}
		}

		dto.setTotal(totalCount);
		dto.setDuplicate(totalCount - (invalidCount + validNumbers.size()));
		dto.setInvalid(invalidCount);
	}

	@Override
	public Integer saveImageUpload(MultipartFile excelFile, Integer type) {
		// Directory where files will be saved
		UserToken auth = (UserToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		File directory = new File(type == 1 ? imageUploadPath : videoUploadPath + auth.getId());
		if (!directory.exists()) {
			directory.mkdirs();
		}
		File file = new File(directory,
				type == 1 ? "image_" : "video_" + new Date().getTime() + "_" + excelFile.getOriginalFilename());
		try {
			System.out.println(file.getPath());
			if (!file.exists()) {
				file.createNewFile();
			}
			excelFile.transferTo(file);
			ImageUpload image = new ImageUpload();
			image.setImagePath(file.getPath());
			image.setType(type);
			image.setCreatedBy(auth.getId().intValue());
			image = imageUploadRepository.save(image);
			return image.getImageUploadsId();
		} catch (IllegalStateException e) {
			logger.error("Error while saving image in saveImageUpload()", e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("Error while saving image in saveImageUpload()", e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public byte[] getImage(Integer imageuploadId) throws IOException {
		ImageUpload image = imageUploadRepository.findOne(imageuploadId);
		Path path = Paths.get(image.getImagePath());
		byte[] data = Files.readAllBytes(path);
		return data;
	}

	@Override
	public FileUploadCountsDto saveGroupSMS(FileUploadCountsDto dto, List<Contacts> contacts) {
		Set<String> validNumbers = new HashSet<>();
		Integer invalidCount = 0;
		Integer totalCount = 0;

		if (null != contacts) {
			validNumbers.addAll(contacts.stream().map(e -> e.getMsisdn()).collect(Collectors.toList()));
		}

		dto.setTotal(totalCount);
		dto.setDuplicate(totalCount - (invalidCount + validNumbers.size()));
		dto.setInvalid(invalidCount);
		return dto;
	}

	@Override
	public List<SmsDraft> fetchSmsDraft() {
		UserToken auth = (UserToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return smsDraftRepository.findByDraftUploadedby(auth.getId().intValue());
	}

	@Override
	public void saveDraft(SmsDraft draft) {
		UserToken auth = (UserToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		draft.setDraftType(1);
		draft.setDraftUploadedby(auth.getId().intValue());
		draft.setDraftCreateddate(new Date());
		smsDraftRepository.save(draft);
	}

	@Override
	public Map<String, Object> saveCustomFileDetails(MultipartFile excelFile) {
		UserToken auth = (UserToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> map = new LinkedHashMap<>();
		File directory = new File(smsUploadsPath + "temp");
		if (!directory.exists()) {
			directory.mkdir();
		}
		String fileName = System.currentTimeMillis() + "_" + excelFile.getOriginalFilename();
		File file = new File(directory, fileName);
		System.out.println(file.getPath());
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			excelFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<ArrayList<Object>> list = new ArrayList<>();
		try {
            CustomUploadFile custupFIleObj = new CustomUploadFile(auth.getId().intValue() , getSendSmsObject(file, ""), file.getAbsolutePath(), null, auth.getSmppId());
            list = custupFIleObj.getSampleData();
        } catch (Exception ex) {
            logger.error("error while fetching sample data", ex);
        }
		map.put("sampledata", list);
		map.put("fileName", fileName);
        return map;
	}
	
	private org.srisairam.sms.SendSmsBean getSendSmsObject(File uploadFileObj, String message) throws Exception {
        org.srisairam.sms.SendSmsBean smsObj = new org.srisairam.sms.SendSmsBean();
        smsObj.setUploadFilePath(uploadFileObj != null ? uploadFileObj.getAbsolutePath() : null);
        smsObj.setMessageType(org.srisairam.enums.MessageType.ENGLISH);
        smsObj.setScheduleDateTime(null);
        smsObj.setSenderId(0);
        smsObj.setSmppId(0);
        smsObj.setScheduleTime(null);
        smsObj.setMobileNumbers(null);
        smsObj.setSmsSendingType(null);
        smsObj.setMessage(message);
        return smsObj;
    }

	@Override
	public ArrayList<ArrayList<Object>> previewCustomSms(SmsDetailsDto smsDetailsDto) {
		UserToken auth = (UserToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		File directory = new File(smsUploadsPath + "temp");
		if (!directory.exists()) {
			directory.mkdir();
		}
		File file = new File(directory, smsDetailsDto.getFilepath());
		if(!file.exists()){
			return null;
		}
		ArrayList<ArrayList<Object>> list = new ArrayList<>();
		try {
            CustomUploadFile custupFIleObj = new CustomUploadFile(auth.getId().intValue() , getSendSmsObject(file, smsDetailsDto.getSmsMessage()), file.getAbsolutePath(), null, auth.getSmppId());
            list = custupFIleObj.getPreViewData();
        } catch (Exception ex) {
            logger.error("error while fetching sample data", ex);
        }
		return list;
	}

}
