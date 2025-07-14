package com.AOA.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AOA.dto.DtoHome;
import com.AOA.dto.DtoRoom;
import com.AOA.entities.Home;
import com.AOA.entities.Room;
import com.AOA.repository.HomeRepository;
import com.AOA.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService {
	
	@Autowired
	private HomeRepository homeRepository;
	
	@Override
	public DtoHome findDtoHomeById(Long id) {
		DtoHome dtoHome = new DtoHome();
		Optional<Home> optional = homeRepository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		
		Home dbHome = optional.get();
		BeanUtils.copyProperties(dbHome, dtoHome);
		
		List<Room> dbRooms = optional.get().getRooms();
		if(dbRooms != null && !dbRooms.isEmpty()) {
			for(Room room: dbRooms) {
				DtoRoom dtoRoom = new DtoRoom();
				BeanUtils.copyProperties(room, dtoRoom);
				dtoHome.getRooms().add(dtoRoom);
			}
		}
		return dtoHome;
	} 
}
