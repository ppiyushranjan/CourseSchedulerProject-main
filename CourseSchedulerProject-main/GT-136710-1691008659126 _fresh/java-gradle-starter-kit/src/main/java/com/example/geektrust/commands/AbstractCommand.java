package com.example.geektrust.commands;

import com.example.geektrust.services.IAllotmentService;

public abstract class AbstractCommand implements ICommand{
    protected final IAllotmentService allotmentService;

    public AbstractCommand(IAllotmentService allotmentService) {
        this.allotmentService = allotmentService;
    }
}
