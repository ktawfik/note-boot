
CREATE TABLE `note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) NOT NULL,
  `creation_date` datetime NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;


CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


CREATE TABLE `note_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_id` int(11) NOT NULL,
  `note_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_NOTE_ID_idx` (`note_id`),
  KEY `FK_TAG_ID_idx` (`tag_id`),
  CONSTRAINT `F_NOTES_IDX` FOREIGN KEY (`note_id`) REFERENCES `note` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `F_TAGS_IDX` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


ALTER TABLE `note-db`.`note_tags` 
ADD CONSTRAINT `FK_57o494t6dpix2b3wm7lt6j1l7`
  FOREIGN KEY (`tag_id`)
  REFERENCES `note-db`.`tag` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
INSERT INTO `note-db`.`tag` (`name`) VALUES ('Education');
INSERT INTO `note-db`.`tag` (`name`) VALUES ('Music');
INSERT INTO `note-db`.`tag` (`name`) VALUES ('Sport');
INSERT INTO `note-db`.`tag` (`name`) VALUES ('Personal');


