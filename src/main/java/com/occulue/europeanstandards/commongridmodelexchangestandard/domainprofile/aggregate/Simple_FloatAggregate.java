package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * Aggregate handler for Simple_Float as outlined for the CQRS pattern, all write responsibilities
 * related to Simple_Float are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class Simple_FloatAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public Simple_FloatAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public Simple_FloatAggregate(CreateSimple_FloatCommand command) throws Exception {
    LOGGER.info("Handling command CreateSimple_FloatCommand");
    CreateSimple_FloatEvent event = new CreateSimple_FloatEvent(command.getSimple_FloatId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSimple_FloatCommand command) throws Exception {
    LOGGER.info("handling command UpdateSimple_FloatCommand");
    UpdateSimple_FloatEvent event =
        new UpdateSimple_FloatEvent(command.getSimple_FloatId(), command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSimple_FloatCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSimple_FloatCommand");
    apply(new DeleteSimple_FloatEvent(command.getSimple_FloatId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToSimple_FloatCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToSimple_FloatCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToSimple_FloatEvent(command.getSimple_FloatId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromSimple_FloatCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromSimple_FloatCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromSimple_FloatEvent(command.getSimple_FloatId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSimple_FloatEvent event) {
    LOGGER.info("Event sourcing CreateSimple_FloatEvent");
    this.simple_FloatId = event.getSimple_FloatId();
  }

  @EventSourcingHandler
  void on(UpdateSimple_FloatEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.value = event.getValue();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToSimple_FloatEvent event) {
    LOGGER.info("Event sourcing AssignValueToSimple_FloatEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromSimple_FloatEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromSimple_FloatEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID simple_FloatId;

  private FloatProxy value = null;
  private VsConverter maxModulationIndex = null;
  private AnalogControl maxValue = null;
  private AnalogControl minValue = null;
  private SetPoint normalValue = null;
  private GeneratingUnit longPF = null;
  private GeneratingUnit shortPF = null;
  private CurveData xvalue = null;
  private CurveData y1value = null;
  private CurveData y2value = null;
  private RegularTimePoint value1 = null;
  private RegularTimePoint value2 = null;
  private AsynchronousMachine iaIrRatio = null;
  private AsynchronousMachine rxLockedRotorRatio = null;
  private ExternalNetworkInjection maxR0ToX0Ratio = null;
  private ExternalNetworkInjection maxR1ToX1Ratio = null;
  private ExternalNetworkInjection maxZ0ToZ1Ratio = null;
  private ExternalNetworkInjection minR0ToX0Ratio = null;
  private ExternalNetworkInjection minR1ToX1Ratio = null;
  private ExternalNetworkInjection minZ0ToZ1Ratio = null;
  private RotatingMachine ratedPowerFactor = null;
  private SynchronousMachine mu = null;
  private TapChangerTablePoint ratio = null;
  private LoadResponseCharacteristic pConstantCurrent = null;
  private LoadResponseCharacteristic pConstantImpedance = null;
  private LoadResponseCharacteristic pConstantPower = null;
  private LoadResponseCharacteristic pFrequencyExponent = null;
  private LoadResponseCharacteristic pVoltageExponent = null;
  private LoadResponseCharacteristic qConstantCurrent = null;
  private LoadResponseCharacteristic qConstantImpedance = null;
  private LoadResponseCharacteristic qConstantPower = null;
  private LoadResponseCharacteristic qFrequencyExponent = null;
  private LoadResponseCharacteristic qVoltageExponent = null;
  private SvShuntCompensatorSections sections = null;
  private SvTapStep position = null;
  private RotatingMachineDynamics damping = null;
  private RotatingMachineDynamics saturationFactor = null;
  private RotatingMachineDynamics saturationFactor120 = null;
  private SynchronousMachineDetailed efdBaseRatio = null;
  private SynchronousMachineDetailed saturationFactor120QAxis = null;
  private SynchronousMachineDetailed saturationFactorQAxis = null;
  private SynchronousMachineTimeConstantReactance ks = null;
  private GovHydroIEEE2 uc = null;
  private GovHydroIEEE2 uo = null;
  private GovSteamIEEE1 k1 = null;
  private GovSteamIEEE1 k2 = null;
  private GovSteamIEEE1 k3 = null;
  private GovSteamIEEE1 k4 = null;
  private GovSteamIEEE1 k5 = null;
  private GovSteamIEEE1 k6 = null;
  private GovSteamIEEE1 k7 = null;
  private GovSteamIEEE1 k8 = null;
  private GovCT1 aset = null;
  private GovCT1 rclose = null;
  private GovCT1 ropen = null;
  private GovGAST1 a = null;
  private GovGAST1 b = null;
  private GovGAST1 ltrate = null;
  private GovGAST1 rmax = null;
  private GovGAST2 c = null;
  private GovGAST3 bca = null;
  private GovGAST3 kac = null;
  private GovGAST3 kca = null;
  private GovGAST3 ksi = null;
  private GovGAST3 ky = null;
  private GovHydro1 velm = null;
  private GovHydro3 velcl = null;
  private GovHydro3 velop = null;
  private GovHydro4 bmax = null;
  private GovHydroFrancis va = null;
  private GovHydroFrancis vc = null;
  private GovHydroPID2 ki = null;
  private GovHydroPID2 velmax = null;
  private GovHydroPID2 velmin = null;
  private GovHydroWEH rpg = null;
  private GovHydroWEH rpp = null;
  private GovSteam2 k = null;
  private GovSteamEU chc = null;
  private GovSteamEU cho = null;
  private GovSteamFV4 svmn = null;
  private GovSteamFV4 svmx = null;
  private MechLoad1 d = null;
  private MechLoad1 e = null;
  private ExcIEEEAC1A seve1 = null;
  private ExcIEEEAC1A seve2 = null;
  private ExcIEEEAC5A seefd1 = null;
  private ExcIEEEAC5A seefd2 = null;
  private ExcANS kce = null;
  private ExcAVR1 ka = null;
  private ExcAVR1 kf = null;
  private ExcAVR1 se1 = null;
  private ExcAVR1 se2 = null;
  private ExcAVR4 ke = null;
  private ExcAVR4 kif = null;
  private ExcSCRX rcrfd = null;
  private ExcSCRX tatb = null;
  private OverexcLimIEEE kramp = null;
  private PssIEEE4B bwh1 = null;
  private PssIEEE4B bwh2 = null;
  private PssIEEE4B bwl1 = null;
  private PssIEEE4B bwl2 = null;
  private PssIEEE4B omeganh1 = null;
  private PssIEEE4B omeganh2 = null;
  private PssIEEE4B omeganl1 = null;
  private PssIEEE4B omeganl2 = null;
  private Pss1 kpe = null;
  private Pss1 kw = null;
  private Pss5 kpss = null;
  private PssPTIST3 nav = null;
  private PssPTIST3 ncl = null;
  private PssPTIST3 ncr = null;
  private PFVArType1IEEEPFController vpfcbw = null;
  private PFVArType1IEEEVArController vvarcbw = null;
  private VAdjIEEE adjslew = null;
  private VAdjIEEE vadjf = null;
  private PFVArType2IEEEPFController vs = null;
  private WindContPType3IEC zeta = null;
  private WindContPitchAngleIEC dthetamax = null;
  private WindContPitchAngleIEC dthetamin = null;
  private WindContRotorRIEC komegafilt = null;
  private WindContRotorRIEC kpfilt = null;
  private WindDynamicsLookupTable input = null;
  private WindDynamicsLookupTable output = null;
  private WindGenTurbineType3aIEC kpc = null;
  private WindGenTurbineType3bIEC fducw = null;
  private WindPitchContEmulIEC kdroop = null;
  private WindPitchContEmulIEC kipce = null;
  private WindPitchContEmulIEC kppce = null;
  private WindPlantFreqPcontrolIEC kiwpp = null;
  private WindPlantFreqPcontrolIEC kpwpp = null;
  private WindPlantReactiveControlIEC kiwpx = null;
  private WindPlantReactiveControlIEC kpwpx = null;
  private LoadComposite epfd = null;
  private LoadComposite epfs = null;
  private LoadComposite epvd = null;
  private LoadComposite epvs = null;
  private LoadComposite eqfd = null;
  private LoadComposite eqfs = null;
  private LoadComposite eqvd = null;
  private LoadComposite eqvs = null;
  private LoadComposite lfrac = null;
  private LoadComposite pfrac = null;
  private LoadGenericNonLinear bs = null;
  private LoadGenericNonLinear bt = null;
  private LoadGenericNonLinear ls = null;
  private LoadGenericNonLinear lt = null;
  private LoadGenericNonLinear pt = null;
  private LoadGenericNonLinear qt = null;
  private LoadStatic ep1 = null;
  private LoadStatic ep2 = null;
  private LoadStatic ep3 = null;
  private LoadStatic eq1 = null;
  private LoadStatic eq2 = null;
  private LoadStatic eq3 = null;
  private LoadStatic kp1 = null;
  private LoadStatic kp2 = null;
  private LoadStatic kp3 = null;
  private LoadStatic kp4 = null;
  private LoadStatic kpf = null;
  private LoadStatic kq1 = null;
  private LoadStatic kq2 = null;
  private LoadStatic kq3 = null;
  private LoadStatic kq4 = null;
  private LoadStatic kqf = null;
  private LoadMotor lfac = null;
  private ProprietaryParameterDynamics floatParameterValue = null;
  private Diagram x1InitialView = null;
  private Diagram x2InitialView = null;
  private Diagram y1InitialView = null;
  private Diagram y2InitialView = null;
  private DiagramObject offsetX = null;
  private DiagramObject offsetY = null;
  private DiagramObjectPoint xPosition = null;
  private DiagramObjectPoint yPosition = null;
  private DiagramObjectPoint zPosition = null;

  private static final Logger LOGGER = Logger.getLogger(Simple_FloatAggregate.class.getName());
}
