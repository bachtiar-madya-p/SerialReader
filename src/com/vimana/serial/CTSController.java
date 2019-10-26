/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vimana.serial;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author permadi
 */
public class CTSController {

    public String read() {
        boolean isOn = false;
        String out = null;
        try {

            String data = "";
            String fileName = "/home/vimana/cts.txt";
            //String fileName = "./cts.txt";
            data = new String(Files.readAllBytes(Paths.get(fileName)));
            if (data.equals("1")) {
                isOn = true;
            }
            if (data.equals("0")) {
                isOn = false;
            }
            out = data;

        } catch (IOException ex) {
            Logger.getLogger(CTSController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }

    public boolean ON() {
        boolean isOn = false;
        try {
            //Path path = Paths.get("/Users/permadi/Documents/Project/PT Vimana/Version3.0/SerialUploaderV3.0/target/properties/cts.txt");
            Path path = Paths.get("/home/vimana/cts.txt");
            //Path path = Paths.get("./cts.txt");

            Charset charset = StandardCharsets.UTF_8;

            String content = new String(Files.readAllBytes(path), charset);

            if (content.equals("0\n") || content.equals("0")) {
                content = content.replace("0", "1");
                isOn = true;
            }

            Files.write(path, content.getBytes(charset));
        } catch (IOException ex) {
            Logger.getLogger(CTSController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isOn;
    }

    public boolean OFF() {
        boolean isOff = false;
        try {
            //Path path = Paths.get("/Users/permadi/Documents/Project/PT Vimana/Version3.0/SerialUploaderV3.0/target/properties/cts.txt");
            Path path = Paths.get("/home/vimana/cts.txt");

            //Path path = Paths.get("./cts.txt");

            Charset charset = StandardCharsets.UTF_8;

            String content = new String(Files.readAllBytes(path), charset);

            if (content.equals("1\n") || content.equals("1")) {
                content = content.replace("1", "0");
                isOff = true;
            }

            Files.write(path, content.getBytes(charset));
        } catch (IOException ex) {
            Logger.getLogger(CTSController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isOff;
    }

}
