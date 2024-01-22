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
 * Aggregate handler for BooleanProxy as outlined for the CQRS pattern, all write responsibilities
 * related to BooleanProxy are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class BooleanProxyAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public BooleanProxyAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public BooleanProxyAggregate(CreateBooleanProxyCommand command) throws Exception {
    LOGGER.info("Handling command CreateBooleanProxyCommand");
    CreateBooleanProxyEvent event = new CreateBooleanProxyEvent(command.getBooleanProxyId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateBooleanProxyCommand command) throws Exception {
    LOGGER.info("handling command UpdateBooleanProxyCommand");
    UpdateBooleanProxyEvent event = new UpdateBooleanProxyEvent(command.getBooleanProxyId());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteBooleanProxyCommand command) throws Exception {
    LOGGER.info("Handling command DeleteBooleanProxyCommand");
    apply(new DeleteBooleanProxyEvent(command.getBooleanProxyId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateBooleanProxyEvent event) {
    LOGGER.info("Event sourcing CreateBooleanProxyEvent");
    this.booleanProxyId = event.getBooleanProxyId();
  }

  @EventSourcingHandler
  void on(UpdateBooleanProxyEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID booleanProxyId;

  private BoundaryExtensions boundaryPoint = null;
  private Analog positiveFlowIn = null;
  private Control operationInProgress = null;
  private LimitSet percentageLimitsFlag = null;
  private Quality61850 badReference = null;
  private Quality61850 estimatorReplaced = null;
  private Quality61850 failure = null;
  private Quality61850 oldData = null;
  private Quality61850 operatorBlocked = null;
  private Quality61850 oscillatory = null;
  private Quality61850 outOfRange = null;
  private Quality61850 overFlow = null;
  private Quality61850 suspect = null;
  private Quality61850 test = null;
  private AsynchronousMachine converterFedDrive = null;
  private AsynchronousMachine reversible = null;
  private ExternalNetworkInjection ikSecond = null;
  private PowerTransformer partOfGeneratorUnitFlag = null;
  private PowerTransformer operationalValuesConsidered = null;
  private SeriesCompensator varistorPresent = null;
  private ShuntCompensator grounded = null;
  private SwitchProxy normalOpen = null;
  private SwitchProxy retained = null;
  private SynchronousMachine earthing = null;
  private TapChanger ltcFlag = null;
  private LoadResponseCharacteristic exponentModel = null;
  private EquivalentInjection regulationCapability = null;
  private SwitchIt open = null;
  private SvStatus inService = null;
  private DynamicsFunctionBlock enabled = null;
  private GovCT1 wfspd = null;
  private GovGAST2 z = null;
  private GovHydro3 governorControl = null;
  private GovHydroDD inputSignal = null;
  private GovHydroFrancis waterTunnelSurgeChamberSimulation = null;
  private GovHydroPelton simplifiedPelton = null;
  private GovHydroPelton staticCompensating = null;
  private GovHydroPID2 feedbackSignal = null;
  private GovSteam1 sdb1 = null;
  private GovSteam1 sdb2 = null;
  private GovSteam1 valve = null;
  private TurbLCFB1 fbf = null;
  private TurbLCFB1 pbf = null;
  private TurbLCFB1 speedReferenceGovernor = null;
  private ExcIEEEDC1A exclim = null;
  private ExcIEEEDC1A uelin = null;
  private ExcIEEEDC4B oelin = null;
  private ExcIEEEST1A pssin = null;
  private ExcAC1A hvlvgates = null;
  private ExcAC2A hvgate = null;
  private ExcAC2A lvgate = null;
  private ExcAC8B inlim = null;
  private ExcAC8B pidlim = null;
  private ExcAC8B telim = null;
  private ExcAC8B vtmult = null;
  private ExcAVR4 imul = null;
  private ExcBBC switchIt = null;
  private ExcDC2A vtlim = null;
  private ExcDC3A efdlim = null;
  private ExcDC3A1 vblim = null;
  private ExcSCRX cswitch = null;
  private ExcSK qconoff = null;
  private ExcSK remote = null;
  private ExcST4B uel = null;
  private ExcST6B k1 = null;
  private ExcST6B vilim = null;
  private ExcST6B vmult = null;
  private OverexcLimX2 m = null;
  private Pss1 vadat = null;
  private Pss1A kd = null;
  private Pss5 ctw2 = null;
  private Pss5 isfreq = null;
  private PssPTIST3 isw = null;
  private PFVArType1IEEEPFController ovex = null;
  private PFVArType2IEEEPFController exlon = null;
  private PFVArType2Common1 j = null;
  private WindContCurrLimIEC mdfslim = null;
  private WindContCurrLimIEC mqpri = null;
  private WindContPType3IEC mplvrt = null;
  private WindGenTurbineType3bIEC mwtcwp = null;
  private WindPlantReactiveControlIEC mwppf = null;
  private WindPlantReactiveControlIEC mwpu = null;
  private WindPlantUserDefined proprietary = null;
  private ProprietaryParameterDynamics booleanParameterValue = null;
  private DiagramObject polygonFlag = null;

  private static final Logger LOGGER = Logger.getLogger(BooleanProxyAggregate.class.getName());
}
