package com.devseries.myFirstModule.components;

import javax.baja.alarm.ext.BAlarmSourceExt;
import javax.baja.alarm.ext.offnormal.BBooleanChangeOfStateAlgorithm;
import javax.baja.control.BBooleanPoint;
import javax.baja.control.BBooleanWritable;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.NoSlotomatic;
import javax.baja.status.BStatus;
import javax.baja.status.BStatusBoolean;
import javax.baja.sys.*;

@NoSlotomatic
@NiagaraType
@NiagaraAction(name = "createBooleanWritable")
@NiagaraAction(name = "createBooleanPoint")

public class BComponentCreator extends BComponent {
    public static final Action createBooleanWritable = newAction(0, null);

    public void createBooleanWritable() { invoke(createBooleanWritable, null, null); }

    public static final Action createBooleanPoint = newAction(0, null);

    public void createBooleanPoint() { invoke(createBooleanPoint, null, null); }

    @Override
    public Type getType() { return TYPE; }
    public static final Type TYPE = Sys.loadType(BComponentCreator.class);

    public BComponentCreator() {}

    private static final BIcon icon = BIcon.make("module://myFirstModule/images/wand.png");

    public BIcon getIcon(){
        return icon;
    }

    private String getUniqueName(BComponent parent, String baseName) {
        if (parent == null) {
            throw new BajaRuntimeException("Parent component is null while generating unique name.");
        }

        String name = baseName;
        int index = 1;

        while (parent.get(name) != null) {
            name = baseName + index;
            index++;
        }

        return name;
    }

    private void addToParent(BComponent component, String baseName) {
        BComplex parentComplex = getParent(); // Get the parent as BComplex
        if (parentComplex == null) {
            throw new BajaRuntimeException("Parent component is null. Ensure this component is added to a valid parent.");
        }

        // Cast to BComponent
        if (!(parentComplex instanceof BComponent)) {
            throw new BajaRuntimeException("Parent is not a BComponent. Found: " + parentComplex.getClass().getName());
        }
        BComponent parent = (BComponent) parentComplex;

        String uniqueName = getUniqueName(parent, baseName);
        try {
            parent.add(uniqueName, component);
        } catch (Exception e) {
            throw new BajaRuntimeException("Error adding component to parent", e);
        }
    }

    public void doCreateBooleanWritable() {
        BBooleanWritable bBooleanWritable = generateBooleanWritable();
        addToParent(bBooleanWritable, "BooleanWritable");
    }

    public void doCreateBooleanPoint() {
        BBooleanPoint bBooleanPoint = generateBooleanPoint();
        addToParent(bBooleanPoint, "BooleanPoint");
    }

    public BBooleanWritable generateBooleanWritable() {
        BBooleanWritable bBooleanWritable = new BBooleanWritable();
        bBooleanWritable.setFallback(new BStatusBoolean(false, BStatus.ok));
        BAlarmSourceExt bAlarmSourceExt = new BAlarmSourceExt();
        bAlarmSourceExt.setOffnormalAlgorithm(new BBooleanChangeOfStateAlgorithm());
        bBooleanWritable.add("alarmExt", bAlarmSourceExt);
        return bBooleanWritable;
    }

    public BBooleanPoint generateBooleanPoint() {
        BBooleanPoint bBooleanPoint = new BBooleanPoint();
        bBooleanPoint.setOut(new BStatusBoolean(false, BStatus.ok));
        BAlarmSourceExt bAlarmSourceExt = new BAlarmSourceExt();
        bAlarmSourceExt.setOffnormalAlgorithm(new BBooleanChangeOfStateAlgorithm());
        bBooleanPoint.add("alarmExt", bAlarmSourceExt);
        return bBooleanPoint;
    }

}
