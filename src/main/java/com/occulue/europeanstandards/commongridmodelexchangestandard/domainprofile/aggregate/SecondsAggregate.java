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
 * Aggregate handler for Seconds as outlined for the CQRS pattern, all write responsibilities
 * related to Seconds are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SecondsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SecondsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SecondsAggregate(CreateSecondsCommand command) throws Exception {
    LOGGER.info("Handling command CreateSecondsCommand");
    CreateSecondsEvent event =
        new CreateSecondsEvent(command.getSecondsId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSecondsCommand command) throws Exception {
    LOGGER.info("handling command UpdateSecondsCommand");
    UpdateSecondsEvent event =
        new UpdateSecondsEvent(
            command.getSecondsId(), command.getMultiplier(), command.getUnit(), command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSecondsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSecondsCommand");
    apply(new DeleteSecondsEvent(command.getSecondsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToSecondsCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToSecondsCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToSecondsEvent(command.getSecondsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromSecondsCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromSecondsCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromSecondsEvent(command.getSecondsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSecondsEvent event) {
    LOGGER.info("Event sourcing CreateSecondsEvent");
    this.secondsId = event.getSecondsId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateSecondsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
    this.value = event.getValue();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToSecondsEvent event) {
    LOGGER.info("Event sourcing AssignValueToSecondsEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromSecondsEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromSecondsEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID secondsId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private RegularIntervalSchedule timeStep = null;
  private OperationalLimitType acceptableDuration = null;
  private ShuntCompensator aVRDelay = null;
  private RotatingMachineDynamics inertia = null;
  private SynchronousMachineTimeConstantReactance tc = null;
  private SynchronousMachineTimeConstantReactance tpdo = null;
  private SynchronousMachineTimeConstantReactance tppdo = null;
  private SynchronousMachineTimeConstantReactance tppqo = null;
  private SynchronousMachineTimeConstantReactance tpqo = null;
  private AsynchronousMachineTimeConstantReactance tpo = null;
  private AsynchronousMachineTimeConstantReactance tppo = null;
  private GovHydroIEEE0 t1 = null;
  private GovHydroIEEE0 t2 = null;
  private GovHydroIEEE0 t3 = null;
  private GovHydroIEEE0 t4 = null;
  private GovHydroIEEE2 tg = null;
  private GovHydroIEEE2 tp = null;
  private GovHydroIEEE2 tr = null;
  private GovHydroIEEE2 tw = null;
  private GovSteamIEEE1 t5 = null;
  private GovSteamIEEE1 t6 = null;
  private GovSteamIEEE1 t7 = null;
  private GovCT1 ta = null;
  private GovCT1 tact = null;
  private GovCT1 tb = null;
  private GovCT1 tdgov = null;
  private GovCT1 teng = null;
  private GovCT1 tfload = null;
  private GovCT1 tpelec = null;
  private GovCT1 tsa = null;
  private GovCT1 tsb = null;
  private GovGAST1 tltr = null;
  private GovGAST2 ecr = null;
  private GovGAST2 etd = null;
  private GovGAST2 t = null;
  private GovGAST2 tcd = null;
  private GovGAST2 tf = null;
  private GovGAST2 tt = null;
  private GovGAST2 x = null;
  private GovGAST2 y = null;
  private GovGAST3 tac = null;
  private GovGAST3 td = null;
  private GovGAST3 tsi = null;
  private GovGAST3 ttc = null;
  private GovGAST3 ty = null;
  private GovGAST4 tcm = null;
  private GovGAST4 tm = null;
  private GovGAST4 tv = null;
  private GovHydro4 rperm = null;
  private GovHydro4 rtemp = null;
  private GovHydro4 tblade = null;
  private GovHydroDD tturb = null;
  private GovHydroFrancis ts = null;
  private GovHydroFrancis twnc = null;
  private GovHydroFrancis twng = null;
  private GovHydroFrancis tx = null;
  private GovHydroPID2 treg = null;
  private GovHydroR t8 = null;
  private GovHydroWEH tdv = null;
  private GovHydroWEH tpe = null;
  private GovSteamCC t1hp = null;
  private GovSteamCC t1lp = null;
  private GovSteamCC t3hp = null;
  private GovSteamCC t3lp = null;
  private GovSteamCC t4hp = null;
  private GovSteamCC t4lp = null;
  private GovSteamCC t5hp = null;
  private GovSteamCC t5lp = null;
  private GovSteamEU tdp = null;
  private GovSteamEU ten = null;
  private GovSteamEU tfp = null;
  private GovSteamEU thp = null;
  private GovSteamEU tip = null;
  private GovSteamEU tlp = null;
  private GovSteamEU trh = null;
  private GovSteamEU tvhp = null;
  private GovSteamEU tvip = null;
  private GovSteamFV2 ti = null;
  private GovSteamFV4 tam = null;
  private GovSteamFV4 tdc = null;
  private GovSteamFV4 tf1 = null;
  private GovSteamFV4 tf2 = null;
  private GovSteamFV4 tmp = null;
  private GovSteamSGO pmin = null;
  private ExcIEEEAC1A te = null;
  private ExcIEEEAC5A tf3 = null;
  private ExcIEEEAC6A th = null;
  private ExcIEEEAC6A tj = null;
  private ExcIEEEAC6A tk = null;
  private ExcIEEEAC7B tdr = null;
  private ExcIEEEST1A tb1 = null;
  private ExcIEEEST1A tc1 = null;
  private ExcIEEEST5B tb2 = null;
  private ExcIEEEST5B tc2 = null;
  private ExcIEEEST5B tob1 = null;
  private ExcIEEEST5B tob2 = null;
  private ExcIEEEST5B toc1 = null;
  private ExcIEEEST5B toc2 = null;
  private ExcIEEEST5B tub1 = null;
  private ExcIEEEST5B tub2 = null;
  private ExcIEEEST5B tuc1 = null;
  private ExcIEEEST5B tuc2 = null;
  private ExcIEEEST7B tia = null;
  private ExcAC3A ka = null;
  private ExcAVR4 t1if = null;
  private ExcAVR4 tif = null;
  private ExcELIN1 tfi = null;
  private ExcELIN1 tnu = null;
  private ExcELIN1 ts1 = null;
  private ExcELIN1 ts2 = null;
  private ExcELIN1 tsw = null;
  private ExcELIN2 te2 = null;
  private ExcELIN2 ti3 = null;
  private ExcELIN2 ti4 = null;
  private ExcELIN2 tr4 = null;
  private ExcPIC ta1 = null;
  private ExcPIC ta2 = null;
  private ExcPIC ta3 = null;
  private ExcPIC ta4 = null;
  private ExcREXS kf = null;
  private ExcST6B tvd = null;
  private UnderexcLimIEEE1 tu1 = null;
  private UnderexcLimIEEE1 tu2 = null;
  private UnderexcLimIEEE1 tu3 = null;
  private UnderexcLimIEEE1 tu4 = null;
  private UnderexcLimIEEE2 tul = null;
  private UnderexcLimIEEE2 tup = null;
  private UnderexcLimIEEE2 tuq = null;
  private UnderexcLimIEEE2 tuv = null;
  private PssIEEE2B t10 = null;
  private PssIEEE2B t11 = null;
  private PssIEEE2B t9 = null;
  private PssIEEE2B tw1 = null;
  private PssIEEE2B tw2 = null;
  private PssIEEE2B tw3 = null;
  private PssIEEE2B tw4 = null;
  private PssIEEE4B th1 = null;
  private PssIEEE4B th10 = null;
  private PssIEEE4B th11 = null;
  private PssIEEE4B th12 = null;
  private PssIEEE4B th2 = null;
  private PssIEEE4B th3 = null;
  private PssIEEE4B th4 = null;
  private PssIEEE4B th5 = null;
  private PssIEEE4B th6 = null;
  private PssIEEE4B th7 = null;
  private PssIEEE4B th8 = null;
  private PssIEEE4B th9 = null;
  private PssIEEE4B ti1 = null;
  private PssIEEE4B ti10 = null;
  private PssIEEE4B ti11 = null;
  private PssIEEE4B ti12 = null;
  private PssIEEE4B ti2 = null;
  private PssIEEE4B ti5 = null;
  private PssIEEE4B ti6 = null;
  private PssIEEE4B ti7 = null;
  private PssIEEE4B ti8 = null;
  private PssIEEE4B ti9 = null;
  private PssIEEE4B tl1 = null;
  private PssIEEE4B tl10 = null;
  private PssIEEE4B tl11 = null;
  private PssIEEE4B tl12 = null;
  private PssIEEE4B tl2 = null;
  private PssIEEE4B tl3 = null;
  private PssIEEE4B tl4 = null;
  private PssIEEE4B tl5 = null;
  private PssIEEE4B tl6 = null;
  private PssIEEE4B tl7 = null;
  private PssIEEE4B tl8 = null;
  private PssIEEE4B tl9 = null;
  private Pss1A tdelay = null;
  private PssELIN2 ts3 = null;
  private PssELIN2 ts4 = null;
  private PssELIN2 ts5 = null;
  private PssELIN2 ts6 = null;
  private PssPTIST1 dtc = null;
  private PssPTIST1 dtf = null;
  private PssPTIST1 dtp = null;
  private PssSB4 tx1 = null;
  private PssSB4 tx2 = null;
  private DiscExcContIEEEDEC1A tan = null;
  private DiscExcContIEEEDEC1A tw5 = null;
  private DiscExcContIEEEDEC2A td1 = null;
  private DiscExcContIEEEDEC2A td2 = null;
  private PFVArType1IEEEPFController tpfc = null;
  private PFVArType1IEEEVArController tvarc = null;
  private VAdjIEEE taoff = null;
  private VAdjIEEE taon = null;
  private WindContCurrLimIEC tufilt = null;
  private WindContPType3IEC tdvs = null;
  private WindContPType3IEC tomegafilt = null;
  private WindContPType3IEC tpfilt = null;
  private WindContPType3IEC twref = null;
  private WindContPType4aIEC tpord = null;
  private WindContPType4bIEC tpaero = null;
  private WindContPitchAngleIEC ttheta = null;
  private WindContQIEC tiq = null;
  private WindContQIEC tpost = null;
  private WindContQIEC tqord = null;
  private WindGenTurbineType3aIEC tic = null;
  private WindGenTurbineType3bIEC two = null;
  private WindMechIEC hgen = null;
  private WindMechIEC hwtr = null;
  private WindPlantFreqPcontrolIEC tpft = null;
  private WindPlantFreqPcontrolIEC tpfv = null;
  private WindPlantFreqPcontrolIEC twpffilt = null;
  private WindPlantFreqPcontrolIEC twppfilt = null;
  private WindPlantReactiveControlIEC twpqfilt = null;
  private WindPlantReactiveControlIEC twpufilt = null;
  private WindPlantReactiveControlIEC txft = null;
  private WindPlantReactiveControlIEC txfv = null;
  private WindProtectionIEC tfover = null;
  private WindProtectionIEC tfunder = null;
  private WindProtectionIEC tuover = null;
  private WindProtectionIEC tuunder = null;
  private LoadComposite h = null;
  private LoadGenericNonLinear tq = null;
  private LoadMotor tbkr = null;

  private static final Logger LOGGER = Logger.getLogger(SecondsAggregate.class.getName());
}
