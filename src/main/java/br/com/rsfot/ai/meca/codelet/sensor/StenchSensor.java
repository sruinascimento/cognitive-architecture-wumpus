package br.com.rsfot.ai.meca.codelet.sensor;

import br.unicamp.cst.core.entities.Memory;
import br.unicamp.meca.system1.codelets.SensoryCodelet;

import java.util.List;

public class StenchSensor extends SensoryCodelet {
    private Memory stenchMO;

    public StenchSensor(String id) {
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
