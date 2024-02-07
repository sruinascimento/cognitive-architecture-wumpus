package br.com.rsfot.ai.meca.codelet.sensor;

import br.unicamp.cst.core.entities.Memory;
import br.unicamp.meca.system1.codelets.SensoryCodelet;

import java.util.List;

public class BreezeSensor extends SensoryCodelet {
    private Memory breezeMO;

    public BreezeSensor(String id) {
        super(id);
    }

    @Override
    public void proc(Memory memory) {

    }

    @Override
    public List<Memory> getOutputs() {
        return null;
    }

    @Override
    public void addOutput(Memory memory) {

    }
}
