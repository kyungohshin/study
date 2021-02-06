package org.zerock.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 *
 *
 * @author USER
 * @history
 *          2020. 12. 31. initial creation
 */
@Getter
@Setter
public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int view_count;
}
