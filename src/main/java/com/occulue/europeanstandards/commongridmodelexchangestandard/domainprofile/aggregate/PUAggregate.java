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
 * Aggregate handler for PU as outlined for the CQRS pattern, all write responsibilities related to
 * PU are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PUAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PUAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PUAggregate(CreatePUCommand command) throws Exception {
    LOGGER.info("Handling command CreatePUCommand");
    CreatePUEvent event =
        new CreatePUEvent(command.getPUId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePUCommand command) throws Exception {
    LOGGER.info("handling command UpdatePUCommand");
    UpdatePUEvent event =
        new UpdatePUEvent(
            command.getPUId(), command.getMultiplier(), command.getUnit(), command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePUCommand command) throws Exception {
    LOGGER.info("Handling command DeletePUCommand");
    apply(new DeletePUEvent(command.getPUId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToPUCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToPUCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToPUEvent(command.getPUId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromPUCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromPUCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromPUEvent(command.getPUId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePUEvent event) {
    LOGGER.info("Event sourcing CreatePUEvent");
    this.pUId = event.getPUId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdatePUEvent event) {
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
  void on(AssignValueToPUEvent event) {
    LOGGER.info("Event sourcing AssignValueToPUEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromPUEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromPUEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pUId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private ExternalNetworkInjection voltageFactor = null;
  private SynchronousMachine r0 = null;
  private SynchronousMachine r2 = null;
  private SynchronousMachine satDirectSubtransX = null;
  private SynchronousMachine satDirectSyncX = null;
  private SynchronousMachine satDirectTransX = null;
  private SynchronousMachine x0 = null;
  private SynchronousMachine x2 = null;
  private RotatingMachineDynamics statorLeakageReactance = null;
  private RotatingMachineDynamics statorResistance = null;
  private SynchronousMachineTimeConstantReactance xDirectSubtrans = null;
  private SynchronousMachineTimeConstantReactance xDirectSync = null;
  private SynchronousMachineTimeConstantReactance xDirectTrans = null;
  private SynchronousMachineTimeConstantReactance xQuadSubtrans = null;
  private SynchronousMachineTimeConstantReactance xQuadSync = null;
  private SynchronousMachineTimeConstantReactance xQuadTrans = null;
  private SynchronousMachineEquivalentCircuit r1d = null;
  private SynchronousMachineEquivalentCircuit r1q = null;
  private SynchronousMachineEquivalentCircuit r2q = null;
  private SynchronousMachineEquivalentCircuit rfd = null;
  private SynchronousMachineEquivalentCircuit x1d = null;
  private SynchronousMachineEquivalentCircuit x1q = null;
  private SynchronousMachineEquivalentCircuit x2q = null;
  private SynchronousMachineEquivalentCircuit xad = null;
  private SynchronousMachineEquivalentCircuit xaq = null;
  private SynchronousMachineEquivalentCircuit xf1d = null;
  private SynchronousMachineEquivalentCircuit xfd = null;
  private AsynchronousMachineTimeConstantReactance xp = null;
  private AsynchronousMachineTimeConstantReactance xpp = null;
  private AsynchronousMachineTimeConstantReactance xs = null;
  private AsynchronousMachineEquivalentCircuit rr1 = null;
  private AsynchronousMachineEquivalentCircuit rr2 = null;
  private AsynchronousMachineEquivalentCircuit xlr1 = null;
  private AsynchronousMachineEquivalentCircuit xlr2 = null;
  private AsynchronousMachineEquivalentCircuit xm = null;
  private GovHydroIEEE0 k = null;
  private GovHydroIEEE0 pmax = null;
  private GovHydroIEEE0 pmin = null;
  private GovHydroIEEE2 aturb = null;
  private GovHydroIEEE2 bturb = null;
  private GovHydroIEEE2 gv1 = null;
  private GovHydroIEEE2 gv2 = null;
  private GovHydroIEEE2 gv3 = null;
  private GovHydroIEEE2 gv4 = null;
  private GovHydroIEEE2 gv5 = null;
  private GovHydroIEEE2 gv6 = null;
  private GovHydroIEEE2 kturb = null;
  private GovHydroIEEE2 pgv1 = null;
  private GovHydroIEEE2 pgv2 = null;
  private GovHydroIEEE2 pgv3 = null;
  private GovHydroIEEE2 pgv4 = null;
  private GovHydroIEEE2 pgv5 = null;
  private GovHydroIEEE2 pgv6 = null;
  private GovHydroIEEE2 rperm = null;
  private GovHydroIEEE2 rtemp = null;
  private GovCT1 db = null;
  private GovCT1 dm = null;
  private GovCT1 ka = null;
  private GovCT1 kdgov = null;
  private GovCT1 kigov = null;
  private GovCT1 kiload = null;
  private GovCT1 kimw = null;
  private GovCT1 kpgov = null;
  private GovCT1 kpload = null;
  private GovCT1 ldref = null;
  private GovCT1 maxerr = null;
  private GovCT1 minerr = null;
  private GovCT1 r = null;
  private GovCT1 rdown = null;
  private GovCT1 rup = null;
  private GovCT1 vmax = null;
  private GovCT1 vmin = null;
  private GovCT1 wfnl = null;
  private GovCT2 plim1 = null;
  private GovCT2 plim10 = null;
  private GovCT2 plim2 = null;
  private GovCT2 plim3 = null;
  private GovCT2 plim4 = null;
  private GovCT2 plim5 = null;
  private GovCT2 plim6 = null;
  private GovCT2 plim7 = null;
  private GovCT2 plim8 = null;
  private GovCT2 plim9 = null;
  private GovCT2 prate = null;
  private GovGAST at = null;
  private GovGAST dturb = null;
  private GovGAST kt = null;
  private GovGAST1 fidle = null;
  private GovGAST1 lmax = null;
  private GovGAST1 loadinc = null;
  private GovGAST2 af1 = null;
  private GovGAST2 af2 = null;
  private GovGAST2 bf1 = null;
  private GovGAST2 bf2 = null;
  private GovGAST2 cf2 = null;
  private GovGAST2 k3 = null;
  private GovGAST2 k4 = null;
  private GovGAST2 k5 = null;
  private GovGAST2 k6 = null;
  private GovGAST2 kf = null;
  private GovGAST2 tmax = null;
  private GovGAST2 tmin = null;
  private GovGAST2 w = null;
  private GovGAST3 bp = null;
  private GovGAST3 mnef = null;
  private GovGAST3 mxef = null;
  private GovGAST3 rcmn = null;
  private GovGAST3 rcmx = null;
  private GovGAST4 ktm = null;
  private GovGAST4 rymn = null;
  private GovGAST4 rymx = null;
  private GovGASTWD kd = null;
  private GovGASTWD kdroop = null;
  private GovGASTWD ki = null;
  private GovGASTWD kp = null;
  private GovHydro1 gmax = null;
  private GovHydro1 gmin = null;
  private GovHydro1 hdam = null;
  private GovHydro1 qnl = null;
  private GovHydro3 h0 = null;
  private GovHydro3 k1 = null;
  private GovHydro3 k2 = null;
  private GovHydro3 kg = null;
  private GovHydro3 relec = null;
  private GovHydro3 rgate = null;
  private GovHydro4 bgv0 = null;
  private GovHydro4 bgv1 = null;
  private GovHydro4 bgv2 = null;
  private GovHydro4 bgv3 = null;
  private GovHydro4 bgv4 = null;
  private GovHydro4 bgv5 = null;
  private GovHydro4 gv0 = null;
  private GovHydro4 pgv0 = null;
  private GovHydro4 qn1 = null;
  private GovHydroFrancis am = null;
  private GovHydroFrancis etamax = null;
  private GovHydroFrancis kc = null;
  private GovHydroFrancis qc0 = null;
  private GovHydroFrancis valvmax = null;
  private GovHydroFrancis valvmin = null;
  private GovHydroPelton vav = null;
  private GovHydroPelton vcv = null;
  private GovHydroPID2 atw = null;
  private GovHydroPID2 d = null;
  private GovHydroPID2 g0 = null;
  private GovHydroPID2 g1 = null;
  private GovHydroPID2 g2 = null;
  private GovHydroPID2 p1 = null;
  private GovHydroPID2 p2 = null;
  private GovHydroPID2 p3 = null;
  private GovHydroWEH dicn = null;
  private GovHydroWEH dpv = null;
  private GovHydroWEH fl1 = null;
  private GovHydroWEH fl2 = null;
  private GovHydroWEH fl3 = null;
  private GovHydroWEH fl4 = null;
  private GovHydroWEH fl5 = null;
  private GovHydroWEH fp1 = null;
  private GovHydroWEH fp10 = null;
  private GovHydroWEH fp2 = null;
  private GovHydroWEH fp3 = null;
  private GovHydroWEH fp4 = null;
  private GovHydroWEH fp5 = null;
  private GovHydroWEH fp6 = null;
  private GovHydroWEH fp7 = null;
  private GovHydroWEH fp8 = null;
  private GovHydroWEH fp9 = null;
  private GovHydroWEH gtmxcl = null;
  private GovHydroWEH gtmxop = null;
  private GovHydroWEH pmss1 = null;
  private GovHydroWEH pmss10 = null;
  private GovHydroWEH pmss2 = null;
  private GovHydroWEH pmss3 = null;
  private GovHydroWEH pmss4 = null;
  private GovHydroWEH pmss5 = null;
  private GovHydroWEH pmss6 = null;
  private GovHydroWEH pmss7 = null;
  private GovHydroWEH pmss8 = null;
  private GovHydroWEH pmss9 = null;
  private GovHydroWPID gatmax = null;
  private GovHydroWPID gatmin = null;
  private GovHydroWPID reg = null;
  private GovHydroWPID velmax = null;
  private GovHydroWPID velmin = null;
  private GovSteam0 dt = null;
  private GovSteam2 dbf = null;
  private GovSteamCC dhp = null;
  private GovSteamCC dlp = null;
  private GovSteamCC fhp = null;
  private GovSteamCC flp = null;
  private GovSteamCC pmaxhp = null;
  private GovSteamCC pmaxlp = null;
  private GovSteamCC rhp = null;
  private GovSteamCC rlp = null;
  private GovSteamEU cic = null;
  private GovSteamEU cio = null;
  private GovSteamEU db1 = null;
  private GovSteamEU db2 = null;
  private GovSteamEU hhpmax = null;
  private GovSteamEU ke = null;
  private GovSteamEU kfcor = null;
  private GovSteamEU khp = null;
  private GovSteamEU klp = null;
  private GovSteamEU kwcor = null;
  private GovSteamEU prhmax = null;
  private GovSteamEU simx = null;
  private GovSteamEU wfmax = null;
  private GovSteamEU wfmin = null;
  private GovSteamEU wmax1 = null;
  private GovSteamEU wmax2 = null;
  private GovSteamEU wwmax = null;
  private GovSteamEU wwmin = null;
  private GovSteamFV3 prmax = null;
  private GovSteamFV4 cpsmn = null;
  private GovSteamFV4 cpsmx = null;
  private GovSteamFV4 crmn = null;
  private GovSteamFV4 crmx = null;
  private GovSteamFV4 kdc = null;
  private GovSteamFV4 kf1 = null;
  private GovSteamFV4 kf3 = null;
  private GovSteamFV4 kic = null;
  private GovSteamFV4 kip = null;
  private GovSteamFV4 kit = null;
  private GovSteamFV4 kmp1 = null;
  private GovSteamFV4 kmp2 = null;
  private GovSteamFV4 kpc = null;
  private GovSteamFV4 kpp = null;
  private GovSteamFV4 kpt = null;
  private GovSteamFV4 krc = null;
  private GovSteamFV4 ksh = null;
  private GovSteamFV4 lpi = null;
  private GovSteamFV4 lps = null;
  private GovSteamFV4 pr1 = null;
  private GovSteamFV4 pr2 = null;
  private GovSteamFV4 psmn = null;
  private GovSteamFV4 rsmimn = null;
  private GovSteamFV4 rsmimx = null;
  private GovSteamFV4 rvgmn = null;
  private GovSteamFV4 rvgmx = null;
  private GovSteamFV4 srmn = null;
  private GovSteamFV4 srmx = null;
  private GovSteamFV4 srsmp = null;
  private GovSteamFV4 y = null;
  private GovSteamFV4 yhpmn = null;
  private GovSteamFV4 yhpmx = null;
  private GovSteamFV4 ympmn = null;
  private GovSteamFV4 ympmx = null;
  private TurbLCFB1 emax = null;
  private TurbLCFB1 fb = null;
  private TurbLCFB1 irmax = null;
  private ExcIEEEAC1A vamax = null;
  private ExcIEEEAC1A vamin = null;
  private ExcIEEEAC1A ve1 = null;
  private ExcIEEEAC1A ve2 = null;
  private ExcIEEEAC1A vrmax = null;
  private ExcIEEEAC1A vrmin = null;
  private ExcIEEEAC2A kb = null;
  private ExcIEEEAC2A kh = null;
  private ExcIEEEAC2A vfemax = null;
  private ExcIEEEAC3A efdn = null;
  private ExcIEEEAC3A kn = null;
  private ExcIEEEAC3A kr = null;
  private ExcIEEEAC3A vemin = null;
  private ExcIEEEAC4A vimax = null;
  private ExcIEEEAC4A vimin = null;
  private ExcIEEEAC5A efd1 = null;
  private ExcIEEEAC5A efd2 = null;
  private ExcIEEEAC6A vfelim = null;
  private ExcIEEEAC6A vhmax = null;
  private ExcIEEEAC7B kdr = null;
  private ExcIEEEAC7B kf2 = null;
  private ExcIEEEAC7B kia = null;
  private ExcIEEEAC7B kir = null;
  private ExcIEEEAC7B kl = null;
  private ExcIEEEAC7B kpa = null;
  private ExcIEEEAC7B kpr = null;
  private ExcIEEEDC2A exclim = null;
  private ExcIEEEDC3A kv = null;
  private ExcIEEEST1A ilr = null;
  private ExcIEEEST1A klr = null;
  private ExcIEEEST2A efdmax = null;
  private ExcIEEEST3A km = null;
  private ExcIEEEST3A vbmax = null;
  private ExcIEEEST3A vgmax = null;
  private ExcIEEEST3A vmmax = null;
  private ExcIEEEST3A vmmin = null;
  private ExcIEEEST3A xl = null;
  private ExcIEEEST4B kim = null;
  private ExcIEEEST4B kpm = null;
  private ExcIEEEST6B kci = null;
  private ExcIEEEST6B kff = null;
  private ExcAC1A ks = null;
  private ExcAC2A kb1 = null;
  private ExcAC2A kl1 = null;
  private ExcAC2A vlr = null;
  private ExcAC3A klv = null;
  private ExcAC3A ta = null;
  private ExcAC3A vlv = null;
  private ExcAC8B vpidmax = null;
  private ExcAC8B vpidmin = null;
  private ExcANS ifmn = null;
  private ExcANS ifmx = null;
  private ExcANS vrmn = null;
  private ExcANS vrmx = null;
  private ExcAVR1 e1 = null;
  private ExcAVR1 e2 = null;
  private ExcAVR4 vfmn = null;
  private ExcAVR4 vfmx = null;
  private ExcAVR5 rex = null;
  private ExcAVR7 a1 = null;
  private ExcAVR7 a2 = null;
  private ExcAVR7 a3 = null;
  private ExcAVR7 a4 = null;
  private ExcAVR7 a5 = null;
  private ExcAVR7 a6 = null;
  private ExcAVR7 vmax1 = null;
  private ExcAVR7 vmax3 = null;
  private ExcAVR7 vmax5 = null;
  private ExcAVR7 vmin1 = null;
  private ExcAVR7 vmin3 = null;
  private ExcAVR7 vmin5 = null;
  private ExcBBC efdmin = null;
  private ExcBBC xe = null;
  private ExcDC1A edfmax = null;
  private ExcDC3A1 vb1max = null;
  private ExcELIN1 dpnf = null;
  private ExcELIN1 efmax = null;
  private ExcELIN1 efmin = null;
  private ExcELIN1 ks1 = null;
  private ExcELIN1 ks2 = null;
  private ExcELIN1 smax = null;
  private ExcELIN1 vpi = null;
  private ExcELIN1 vpnf = null;
  private ExcELIN1 vpu = null;
  private ExcELIN2 efdbas = null;
  private ExcELIN2 iefmax = null;
  private ExcELIN2 iefmax2 = null;
  private ExcELIN2 iefmin = null;
  private ExcELIN2 k1ec = null;
  private ExcELIN2 kd1 = null;
  private ExcELIN2 ke2 = null;
  private ExcELIN2 ketb = null;
  private ExcELIN2 pid1max = null;
  private ExcELIN2 seve1 = null;
  private ExcELIN2 seve2 = null;
  private ExcELIN2 ti1 = null;
  private ExcELIN2 upmax = null;
  private ExcELIN2 upmin = null;
  private ExcHU ae = null;
  private ExcHU ai = null;
  private ExcHU atr = null;
  private ExcHU emin = null;
  private ExcHU imax = null;
  private ExcHU imin = null;
  private ExcOEX3T see1 = null;
  private ExcOEX3T see2 = null;
  private ExcPIC se1 = null;
  private ExcPIC se2 = null;
  private ExcPIC vr1 = null;
  private ExcPIC vr2 = null;
  private ExcREXS flimf = null;
  private ExcREXS kefd = null;
  private ExcREXS kii = null;
  private ExcREXS kvi = null;
  private ExcREXS kvp = null;
  private ExcREXS kvphz = null;
  private ExcREXS nvphz = null;
  private ExcREXS vcmax = null;
  private ExcREXS vfmax = null;
  private ExcREXS vfmin = null;
  private ExcREXS xc = null;
  private ExcSK kce = null;
  private ExcSK kgob = null;
  private ExcSK kqi = null;
  private ExcSK kqob = null;
  private ExcSK kqp = null;
  private ExcSK nq = null;
  private ExcSK qz = null;
  private ExcSK uimax = null;
  private ExcSK uimin = null;
  private ExcSK urmax = null;
  private ExcSK urmin = null;
  private ExcSK vtmax = null;
  private ExcSK vtmin = null;
  private ExcSK yp = null;
  private ExcST3A kj = null;
  private ExcST6B kcl = null;
  private ExcST6B kvd = null;
  private OverexcLimIEEE hyst = null;
  private OverexcLimIEEE ifdlim = null;
  private OverexcLimIEEE ifdmax = null;
  private OverexcLimIEEE itfpu = null;
  private OverexcLimIEEE kcd = null;
  private OverexcLim2 koi = null;
  private OverexcLim2 voimax = null;
  private OverexcLim2 voimin = null;
  private OverexcLimX1 efd3 = null;
  private OverexcLimX1 efddes = null;
  private OverexcLimX1 efdrated = null;
  private OverexcLimX1 kmx = null;
  private OverexcLimX1 vlow = null;
  private UnderexcLimIEEE1 kuc = null;
  private UnderexcLimIEEE1 kuf = null;
  private UnderexcLimIEEE1 kui = null;
  private UnderexcLimIEEE1 kul = null;
  private UnderexcLimIEEE1 kur = null;
  private UnderexcLimIEEE1 vucmax = null;
  private UnderexcLimIEEE1 vuimax = null;
  private UnderexcLimIEEE1 vuimin = null;
  private UnderexcLimIEEE1 vulmax = null;
  private UnderexcLimIEEE1 vulmin = null;
  private UnderexcLimIEEE1 vurmax = null;
  private UnderexcLimIEEE2 kfb = null;
  private UnderexcLimIEEE2 p0 = null;
  private UnderexcLimIEEE2 p10 = null;
  private UnderexcLimIEEE2 p4 = null;
  private UnderexcLimIEEE2 p5 = null;
  private UnderexcLimIEEE2 p6 = null;
  private UnderexcLimIEEE2 p7 = null;
  private UnderexcLimIEEE2 p8 = null;
  private UnderexcLimIEEE2 p9 = null;
  private UnderexcLimIEEE2 q0 = null;
  private UnderexcLimIEEE2 q1 = null;
  private UnderexcLimIEEE2 q10 = null;
  private UnderexcLimIEEE2 q2 = null;
  private UnderexcLimIEEE2 q3 = null;
  private UnderexcLimIEEE2 q4 = null;
  private UnderexcLimIEEE2 q5 = null;
  private UnderexcLimIEEE2 q6 = null;
  private UnderexcLimIEEE2 q7 = null;
  private UnderexcLimIEEE2 q8 = null;
  private UnderexcLimIEEE2 q9 = null;
  private UnderexcLimX1 melmax = null;
  private UnderexcLimX2 qo = null;
  private PssIEEE2B ks3 = null;
  private PssIEEE2B vsi1max = null;
  private PssIEEE2B vsi1min = null;
  private PssIEEE2B vsi2max = null;
  private PssIEEE2B vsi2min = null;
  private PssIEEE2B vstmax = null;
  private PssIEEE2B vstmin = null;
  private PssIEEE3B a7 = null;
  private PssIEEE3B a8 = null;
  private PssIEEE4B kh1 = null;
  private PssIEEE4B kh11 = null;
  private PssIEEE4B kh17 = null;
  private PssIEEE4B kh2 = null;
  private PssIEEE4B ki1 = null;
  private PssIEEE4B ki11 = null;
  private PssIEEE4B ki17 = null;
  private PssIEEE4B ki2 = null;
  private PssIEEE4B kl11 = null;
  private PssIEEE4B kl17 = null;
  private PssIEEE4B kl2 = null;
  private PssIEEE4B vhmin = null;
  private PssIEEE4B vlmax = null;
  private PssIEEE4B vlmin = null;
  private Pss1 vsmn = null;
  private Pss1 vsmx = null;
  private Pss1A vcl = null;
  private Pss1A vcu = null;
  private Pss2B ks4 = null;
  private Pss2ST lsmax = null;
  private Pss2ST lsmin = null;
  private Pss5 deadband = null;
  private Pss5 pmm = null;
  private PssELIN2 apss = null;
  private PssELIN2 ppss = null;
  private PssELIN2 psslim = null;
  private PssPTIST1 m = null;
  private PssPTIST3 a0 = null;
  private PssPTIST3 al = null;
  private PssPTIST3 athres = null;
  private PssPTIST3 b0 = null;
  private PssPTIST3 b1 = null;
  private PssPTIST3 b2 = null;
  private PssPTIST3 b3 = null;
  private PssPTIST3 b4 = null;
  private PssPTIST3 b5 = null;
  private PssPTIST3 dl = null;
  private PssPTIST3 lthres = null;
  private PssSB4 kx = null;
  private PssSB4 vsmax = null;
  private PssSB4 vsmin = null;
  private PssSH k0 = null;
  private DiscExcContIEEEDEC1A esc = null;
  private DiscExcContIEEEDEC1A kan = null;
  private DiscExcContIEEEDEC1A ketl = null;
  private DiscExcContIEEEDEC1A vanmax = null;
  private DiscExcContIEEEDEC1A vomax = null;
  private DiscExcContIEEEDEC1A vomin = null;
  private DiscExcContIEEEDEC1A vtc = null;
  private DiscExcContIEEEDEC1A vtlmt = null;
  private DiscExcContIEEEDEC1A vtm = null;
  private DiscExcContIEEEDEC1A vtn = null;
  private DiscExcContIEEEDEC2A vdmax = null;
  private DiscExcContIEEEDEC2A vdmin = null;
  private DiscExcContIEEEDEC2A vk = null;
  private PFVArType1IEEEPFController vitmin = null;
  private PFVArType1IEEEPFController vpf = null;
  private PFVArType1IEEEPFController vpfref = null;
  private PFVArType1IEEEPFController vvtmax = null;
  private PFVArType1IEEEPFController vvtmin = null;
  private PFVArType1IEEEVArController vvar = null;
  private PFVArType1IEEEVArController vvarref = null;
  private VAdjIEEE vadjmax = null;
  private VAdjIEEE vadjmin = null;
  private PFVArType2IEEEPFController pfref = null;
  private PFVArType2IEEEPFController vclmt = null;
  private PFVArType2IEEEPFController vref = null;
  private PFVArType2IEEEVArController qref = null;
  private PFVArType2Common1 max = null;
  private PFVArType2Common1 ref = null;
  private VCompIEEEType1 rc = null;
  private GenICompensationForGenJ rcij = null;
  private GenICompensationForGenJ xcij = null;
  private WindAeroLinearIEC dpomega = null;
  private WindAeroLinearIEC dptheta = null;
  private WindAeroLinearIEC omegazero = null;
  private WindAeroLinearIEC pavail = null;
  private WindContCurrLimIEC imaxdip = null;
  private WindContPType3IEC dpmax = null;
  private WindContPType3IEC dtrisemaxlvrt = null;
  private WindContPType3IEC kdtd = null;
  private WindContPType3IEC omegaoffset = null;
  private WindContPType3IEC pdtdmax = null;
  private WindContPType3IEC rramp = null;
  private WindContPType3IEC temin = null;
  private WindContPType3IEC tpord = null;
  private WindContPType3IEC tuscale = null;
  private WindContPType3IEC udvs = null;
  private WindContPType3IEC updip = null;
  private WindContPType3IEC wdtd = null;
  private WindContPitchAngleIEC kiomega = null;
  private WindContPitchAngleIEC kpomega = null;
  private WindContPitchAngleIEC kpx = null;
  private WindContQIEC iqh1 = null;
  private WindContQIEC iqmax = null;
  private WindContQIEC iqmin = null;
  private WindContQIEC iqpost = null;
  private WindContQIEC kiq = null;
  private WindContQIEC kiu = null;
  private WindContQIEC kpq = null;
  private WindContQIEC kpu = null;
  private WindContQIEC kqv = null;
  private WindContQIEC qmax = null;
  private WindContQIEC qmin = null;
  private WindContQIEC rdroop = null;
  private WindContQIEC udb1 = null;
  private WindContQIEC udb2 = null;
  private WindContQIEC umax = null;
  private WindContQIEC umin = null;
  private WindContQIEC uqdip = null;
  private WindContQIEC uref0 = null;
  private WindContQIEC xdroop = null;
  private WindContRotorRIEC kirr = null;
  private WindContRotorRIEC kprr = null;
  private WindContRotorRIEC rmax = null;
  private WindContRotorRIEC rmin = null;
  private WindGenTurbineType3IEC dipmax = null;
  private WindGenTurbineType3IEC diqmax = null;
  private WindGenType4IEC diqmin = null;
  private WindMechIEC cdrt = null;
  private WindMechIEC kdrt = null;
  private WindPitchContEmulIEC komegaaero = null;
  private WindPitchContEmulIEC omegaref = null;
  private WindPitchContEmulIEC pimax = null;
  private WindPitchContEmulIEC pimin = null;
  private WindPlantFreqPcontrolIEC dprefmax = null;
  private WindPlantFreqPcontrolIEC dprefmin = null;
  private WindPlantFreqPcontrolIEC prefmax = null;
  private WindPlantFreqPcontrolIEC prefmin = null;
  private WindPlantReactiveControlIEC kwpqu = null;
  private WindPlantReactiveControlIEC uwpqdip = null;
  private WindPlantReactiveControlIEC xrefmax = null;
  private WindPlantReactiveControlIEC xrefmin = null;
  private WindProtectionIEC fover = null;
  private WindProtectionIEC funder = null;
  private WindProtectionIEC uover = null;
  private WindProtectionIEC uunder = null;
  private LoadMotor lp = null;
  private LoadMotor lpp = null;
  private LoadMotor ls = null;
  private LoadMotor ra = null;
  private LoadMotor vt = null;

  private static final Logger LOGGER = Logger.getLogger(PUAggregate.class.getName());
}
