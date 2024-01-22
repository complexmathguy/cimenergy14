package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.aggregate;

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
 * Aggregate handler for Pss2B as outlined for the CQRS pattern, all write responsibilities related
 * to Pss2B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class Pss2BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public Pss2BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public Pss2BAggregate(CreatePss2BCommand command) throws Exception {
    LOGGER.info("Handling command CreatePss2BCommand");
    CreatePss2BEvent event =
        new CreatePss2BEvent(
            command.getPss2BId(), command.getInputSignal1Type(), command.getInputSignal2Type());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePss2BCommand command) throws Exception {
    LOGGER.info("handling command UpdatePss2BCommand");
    UpdatePss2BEvent event =
        new UpdatePss2BEvent(
            command.getPss2BId(),
            command.getA(),
            command.getInputSignal1Type(),
            command.getInputSignal2Type(),
            command.getKs1(),
            command.getKs2(),
            command.getKs3(),
            command.getKs4(),
            command.getM(),
            command.getN(),
            command.getT1(),
            command.getT10(),
            command.getT11(),
            command.getT2(),
            command.getT3(),
            command.getT4(),
            command.getT6(),
            command.getT7(),
            command.getT8(),
            command.getT9(),
            command.getTa(),
            command.getTb(),
            command.getTw1(),
            command.getTw2(),
            command.getTw3(),
            command.getTw4(),
            command.getVsi1max(),
            command.getVsi1min(),
            command.getVsi2max(),
            command.getVsi2min(),
            command.getVstmax(),
            command.getVstmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePss2BCommand command) throws Exception {
    LOGGER.info("Handling command DeletePss2BCommand");
    apply(new DeletePss2BEvent(command.getPss2BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignAToPss2BCommand");

    if (a != null && a.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "A already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignAToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAFromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignAFromPss2BCommand");

    if (a == null) throw new ProcessingException("A already has nothing assigned.");

    apply(new UnAssignAFromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignKs1ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKs1ToPss2BCommand");

    if (ks1 != null && ks1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKs1ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKs1FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKs1FromPss2BCommand");

    if (ks1 == null) throw new ProcessingException("Ks1 already has nothing assigned.");

    apply(new UnAssignKs1FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignKs2ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKs2ToPss2BCommand");

    if (ks2 != null && ks2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKs2ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKs2FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKs2FromPss2BCommand");

    if (ks2 == null) throw new ProcessingException("Ks2 already has nothing assigned.");

    apply(new UnAssignKs2FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignKs3ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKs3ToPss2BCommand");

    if (ks3 != null && ks3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKs3ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKs3FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKs3FromPss2BCommand");

    if (ks3 == null) throw new ProcessingException("Ks3 already has nothing assigned.");

    apply(new UnAssignKs3FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignKs4ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKs4ToPss2BCommand");

    if (ks4 != null && ks4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKs4ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKs4FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKs4FromPss2BCommand");

    if (ks4 == null) throw new ProcessingException("Ks4 already has nothing assigned.");

    apply(new UnAssignKs4FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignMToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignMToPss2BCommand");

    if (m != null && m.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "M already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(new AssignMToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMFromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMFromPss2BCommand");

    if (m == null) throw new ProcessingException("M already has nothing assigned.");

    apply(new UnAssignMFromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignNToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignNToPss2BCommand");

    if (n != null && n.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "N already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(new AssignNToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNFromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNFromPss2BCommand");

    if (n == null) throw new ProcessingException("N already has nothing assigned.");

    apply(new UnAssignNFromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignT1ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToPss2BCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromPss2BCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignT10ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT10ToPss2BCommand");

    if (t10 != null && t10.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T10 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT10ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT10FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT10FromPss2BCommand");

    if (t10 == null) throw new ProcessingException("T10 already has nothing assigned.");

    apply(new UnAssignT10FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignT11ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT11ToPss2BCommand");

    if (t11 != null && t11.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T11 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT11ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT11FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT11FromPss2BCommand");

    if (t11 == null) throw new ProcessingException("T11 already has nothing assigned.");

    apply(new UnAssignT11FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignT2ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToPss2BCommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromPss2BCommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignT3ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToPss2BCommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromPss2BCommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignT4ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT4ToPss2BCommand");

    if (t4 != null && t4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT4ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT4FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT4FromPss2BCommand");

    if (t4 == null) throw new ProcessingException("T4 already has nothing assigned.");

    apply(new UnAssignT4FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignT6ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT6ToPss2BCommand");

    if (t6 != null && t6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT6ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT6FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT6FromPss2BCommand");

    if (t6 == null) throw new ProcessingException("T6 already has nothing assigned.");

    apply(new UnAssignT6FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignT7ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT7ToPss2BCommand");

    if (t7 != null && t7.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T7 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT7ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT7FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT7FromPss2BCommand");

    if (t7 == null) throw new ProcessingException("T7 already has nothing assigned.");

    apply(new UnAssignT7FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignT8ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT8ToPss2BCommand");

    if (t8 != null && t8.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T8 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT8ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT8FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT8FromPss2BCommand");

    if (t8 == null) throw new ProcessingException("T8 already has nothing assigned.");

    apply(new UnAssignT8FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignT9ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignT9ToPss2BCommand");

    if (t9 != null && t9.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T9 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT9ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT9FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT9FromPss2BCommand");

    if (t9 == null) throw new ProcessingException("T9 already has nothing assigned.");

    apply(new UnAssignT9FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignTaToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTaToPss2BCommand");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromPss2BCommand");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignTbToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToPss2BCommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromPss2BCommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignTw1ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTw1ToPss2BCommand");

    if (tw1 != null && tw1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTw1ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTw1FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTw1FromPss2BCommand");

    if (tw1 == null) throw new ProcessingException("Tw1 already has nothing assigned.");

    apply(new UnAssignTw1FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignTw2ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTw2ToPss2BCommand");

    if (tw2 != null && tw2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTw2ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTw2FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTw2FromPss2BCommand");

    if (tw2 == null) throw new ProcessingException("Tw2 already has nothing assigned.");

    apply(new UnAssignTw2FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignTw3ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTw3ToPss2BCommand");

    if (tw3 != null && tw3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTw3ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTw3FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTw3FromPss2BCommand");

    if (tw3 == null) throw new ProcessingException("Tw3 already has nothing assigned.");

    apply(new UnAssignTw3FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignTw4ToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTw4ToPss2BCommand");

    if (tw4 != null && tw4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTw4ToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTw4FromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTw4FromPss2BCommand");

    if (tw4 == null) throw new ProcessingException("Tw4 already has nothing assigned.");

    apply(new UnAssignTw4FromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignVsi1maxToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsi1maxToPss2BCommand");

    if (vsi1max != null && vsi1max.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsi1max already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsi1maxToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsi1maxFromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsi1maxFromPss2BCommand");

    if (vsi1max == null) throw new ProcessingException("Vsi1max already has nothing assigned.");

    apply(new UnAssignVsi1maxFromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignVsi1minToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsi1minToPss2BCommand");

    if (vsi1min != null && vsi1min.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsi1min already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsi1minToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsi1minFromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsi1minFromPss2BCommand");

    if (vsi1min == null) throw new ProcessingException("Vsi1min already has nothing assigned.");

    apply(new UnAssignVsi1minFromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignVsi2maxToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsi2maxToPss2BCommand");

    if (vsi2max != null && vsi2max.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsi2max already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsi2maxToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsi2maxFromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsi2maxFromPss2BCommand");

    if (vsi2max == null) throw new ProcessingException("Vsi2max already has nothing assigned.");

    apply(new UnAssignVsi2maxFromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignVsi2minToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsi2minToPss2BCommand");

    if (vsi2min != null && vsi2min.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsi2min already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVsi2minToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsi2minFromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsi2minFromPss2BCommand");

    if (vsi2min == null) throw new ProcessingException("Vsi2min already has nothing assigned.");

    apply(new UnAssignVsi2minFromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignVstmaxToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVstmaxToPss2BCommand");

    if (vstmax != null && vstmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vstmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVstmaxToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVstmaxFromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVstmaxFromPss2BCommand");

    if (vstmax == null) throw new ProcessingException("Vstmax already has nothing assigned.");

    apply(new UnAssignVstmaxFromPss2BEvent(command.getPss2BId()));
  }

  @CommandHandler
  public void handle(AssignVstminToPss2BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVstminToPss2BCommand");

    if (vstmin != null && vstmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vstmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVstminToPss2BEvent(command.getPss2BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVstminFromPss2BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVstminFromPss2BCommand");

    if (vstmin == null) throw new ProcessingException("Vstmin already has nothing assigned.");

    apply(new UnAssignVstminFromPss2BEvent(command.getPss2BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePss2BEvent event) {
    LOGGER.info("Event sourcing CreatePss2BEvent");
    this.pss2BId = event.getPss2BId();
    this.inputSignal1Type = event.getInputSignal1Type();
    this.inputSignal2Type = event.getInputSignal2Type();
  }

  @EventSourcingHandler
  void on(UpdatePss2BEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.a = event.getA();
    this.inputSignal1Type = event.getInputSignal1Type();
    this.inputSignal2Type = event.getInputSignal2Type();
    this.ks1 = event.getKs1();
    this.ks2 = event.getKs2();
    this.ks3 = event.getKs3();
    this.ks4 = event.getKs4();
    this.m = event.getM();
    this.n = event.getN();
    this.t1 = event.getT1();
    this.t10 = event.getT10();
    this.t11 = event.getT11();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.t4 = event.getT4();
    this.t6 = event.getT6();
    this.t7 = event.getT7();
    this.t8 = event.getT8();
    this.t9 = event.getT9();
    this.ta = event.getTa();
    this.tb = event.getTb();
    this.tw1 = event.getTw1();
    this.tw2 = event.getTw2();
    this.tw3 = event.getTw3();
    this.tw4 = event.getTw4();
    this.vsi1max = event.getVsi1max();
    this.vsi1min = event.getVsi1min();
    this.vsi2max = event.getVsi2max();
    this.vsi2min = event.getVsi2min();
    this.vstmax = event.getVstmax();
    this.vstmin = event.getVstmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignAToPss2BEvent");
    this.a = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAFromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignAFromPss2BEvent");
    this.a = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKs1ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignKs1ToPss2BEvent");
    this.ks1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKs1FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignKs1FromPss2BEvent");
    this.ks1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKs2ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignKs2ToPss2BEvent");
    this.ks2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKs2FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignKs2FromPss2BEvent");
    this.ks2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKs3ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignKs3ToPss2BEvent");
    this.ks3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKs3FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignKs3FromPss2BEvent");
    this.ks3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKs4ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignKs4ToPss2BEvent");
    this.ks4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKs4FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignKs4FromPss2BEvent");
    this.ks4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignMToPss2BEvent");
    this.m = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMFromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignMFromPss2BEvent");
    this.m = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignNToPss2BEvent");
    this.n = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNFromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignNFromPss2BEvent");
    this.n = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignT1ToPss2BEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromPss2BEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT10ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignT10ToPss2BEvent");
    this.t10 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT10FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT10FromPss2BEvent");
    this.t10 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT11ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignT11ToPss2BEvent");
    this.t11 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT11FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT11FromPss2BEvent");
    this.t11 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignT2ToPss2BEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromPss2BEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignT3ToPss2BEvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromPss2BEvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT4ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignT4ToPss2BEvent");
    this.t4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT4FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT4FromPss2BEvent");
    this.t4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT6ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignT6ToPss2BEvent");
    this.t6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT6FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT6FromPss2BEvent");
    this.t6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT7ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignT7ToPss2BEvent");
    this.t7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT7FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT7FromPss2BEvent");
    this.t7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT8ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignT8ToPss2BEvent");
    this.t8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT8FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT8FromPss2BEvent");
    this.t8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT9ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignT9ToPss2BEvent");
    this.t9 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT9FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignT9FromPss2BEvent");
    this.t9 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignTaToPss2BEvent");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignTaFromPss2BEvent");
    this.ta = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignTbToPss2BEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromPss2BEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTw1ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignTw1ToPss2BEvent");
    this.tw1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTw1FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignTw1FromPss2BEvent");
    this.tw1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTw2ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignTw2ToPss2BEvent");
    this.tw2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTw2FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignTw2FromPss2BEvent");
    this.tw2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTw3ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignTw3ToPss2BEvent");
    this.tw3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTw3FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignTw3FromPss2BEvent");
    this.tw3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTw4ToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignTw4ToPss2BEvent");
    this.tw4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTw4FromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignTw4FromPss2BEvent");
    this.tw4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsi1maxToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignVsi1maxToPss2BEvent");
    this.vsi1max = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsi1maxFromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignVsi1maxFromPss2BEvent");
    this.vsi1max = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsi1minToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignVsi1minToPss2BEvent");
    this.vsi1min = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsi1minFromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignVsi1minFromPss2BEvent");
    this.vsi1min = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsi2maxToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignVsi2maxToPss2BEvent");
    this.vsi2max = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsi2maxFromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignVsi2maxFromPss2BEvent");
    this.vsi2max = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsi2minToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignVsi2minToPss2BEvent");
    this.vsi2min = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsi2minFromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignVsi2minFromPss2BEvent");
    this.vsi2min = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVstmaxToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignVstmaxToPss2BEvent");
    this.vstmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVstmaxFromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignVstmaxFromPss2BEvent");
    this.vstmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVstminToPss2BEvent event) {
    LOGGER.info("Event sourcing AssignVstminToPss2BEvent");
    this.vstmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVstminFromPss2BEvent event) {
    LOGGER.info("Event sourcing UnAssignVstminFromPss2BEvent");
    this.vstmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pss2BId;

  private InputSignalKind inputSignal1Type;
  private InputSignalKind inputSignal2Type;
  private Simple_Float a = null;
  private PU ks1 = null;
  private PU ks2 = null;
  private PU ks3 = null;
  private PU ks4 = null;
  private IntegerProxy m = null;
  private IntegerProxy n = null;
  private Seconds t1 = null;
  private Seconds t10 = null;
  private Seconds t11 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds t4 = null;
  private Seconds t6 = null;
  private Seconds t7 = null;
  private Seconds t8 = null;
  private Seconds t9 = null;
  private Seconds ta = null;
  private Seconds tb = null;
  private Seconds tw1 = null;
  private Seconds tw2 = null;
  private Seconds tw3 = null;
  private Seconds tw4 = null;
  private PU vsi1max = null;
  private PU vsi1min = null;
  private PU vsi2max = null;
  private PU vsi2min = null;
  private PU vstmax = null;
  private PU vstmin = null;

  private static final Logger LOGGER = Logger.getLogger(Pss2BAggregate.class.getName());
}
