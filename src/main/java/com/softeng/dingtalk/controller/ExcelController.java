package com.softeng.dingtalk.controller;

import com.softeng.dingtalk.service.ExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/api")
public class ExcelController {

    @Autowired
    ExcelService excelService;

    @PostMapping("/excel/ac_data")
    public void downloadAcData(@RequestBody LocalDate date, HttpServletResponse response) throws IOException {
        excelService.writeAcDataByDate(date, response.getOutputStream());
    }


    @PostMapping("/excel/dc_summary_data")
    public void downloadDcSummaryData(@RequestBody LocalDate date, HttpServletResponse response) throws IOException {
        excelService.writeDcSummaryByDate(date, response.getOutputStream());
    }
}
