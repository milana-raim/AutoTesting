package ru.itis;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostData {

    @XmlElement(name = "content", required = true)
    private String content;
}