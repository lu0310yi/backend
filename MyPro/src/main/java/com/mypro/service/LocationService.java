package com.mypro.service;

import com.mypro.beans.Location;
import org.springframework.stereotype.Service;

@Service
public interface LocationService {
    void update(Location location);

    void around(Location location, Double radius);

    void online();

    void offline();
}
