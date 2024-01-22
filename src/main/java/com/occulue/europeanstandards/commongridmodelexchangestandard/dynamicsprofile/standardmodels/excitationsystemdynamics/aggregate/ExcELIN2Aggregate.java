package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.aggregate;

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
 * Aggregate handler for ExcELIN2 as outlined for the CQRS pattern, all write responsibilities
 * related to ExcELIN2 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcELIN2Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcELIN2Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcELIN2Aggregate(CreateExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command CreateExcELIN2Command");
    CreateExcELIN2Event event = new CreateExcELIN2Event(command.getExcELIN2Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcELIN2Command command) throws Exception {
    LOGGER.info("handling command UpdateExcELIN2Command");
    UpdateExcELIN2Event event =
        new UpdateExcELIN2Event(
            command.getExcELIN2Id(),
            command.getEfdbas(),
            command.getIefmax(),
            command.getIefmax2(),
            command.getIefmin(),
            command.getK1(),
            command.getK1ec(),
            command.getK2(),
            command.getK3(),
            command.getK4(),
            command.getKd1(),
            command.getKe2(),
            command.getKetb(),
            command.getPid1max(),
            command.getSeve1(),
            command.getSeve2(),
            command.getTb1(),
            command.getTe(),
            command.getTe2(),
            command.getTi1(),
            command.getTi3(),
            command.getTi4(),
            command.getTr4(),
            command.getUpmax(),
            command.getUpmin(),
            command.getVe1(),
            command.getVe2(),
            command.getXp());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command DeleteExcELIN2Command");
    apply(new DeleteExcELIN2Event(command.getExcELIN2Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEfdbasToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignEfdbasToExcELIN2Command");

    if (efdbas != null && efdbas.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efdbas already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfdbasToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfdbasFromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfdbasFromExcELIN2Command");

    if (efdbas == null) throw new ProcessingException("Efdbas already has nothing assigned.");

    apply(new UnAssignEfdbasFromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignIefmaxToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignIefmaxToExcELIN2Command");

    if (iefmax != null && iefmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Iefmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIefmaxToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIefmaxFromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignIefmaxFromExcELIN2Command");

    if (iefmax == null) throw new ProcessingException("Iefmax already has nothing assigned.");

    apply(new UnAssignIefmaxFromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignIefmax2ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignIefmax2ToExcELIN2Command");

    if (iefmax2 != null && iefmax2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Iefmax2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIefmax2ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIefmax2FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignIefmax2FromExcELIN2Command");

    if (iefmax2 == null) throw new ProcessingException("Iefmax2 already has nothing assigned.");

    apply(new UnAssignIefmax2FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignIefminToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignIefminToExcELIN2Command");

    if (iefmin != null && iefmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Iefmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIefminToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIefminFromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignIefminFromExcELIN2Command");

    if (iefmin == null) throw new ProcessingException("Iefmin already has nothing assigned.");

    apply(new UnAssignIefminFromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignK1ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignK1ToExcELIN2Command");

    if (k1 != null && k1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK1ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1FromExcELIN2Command");

    if (k1 == null) throw new ProcessingException("K1 already has nothing assigned.");

    apply(new UnAssignK1FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignK1ecToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignK1ecToExcELIN2Command");

    if (k1ec != null && k1ec.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K1ec already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK1ecToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK1ecFromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK1ecFromExcELIN2Command");

    if (k1ec == null) throw new ProcessingException("K1ec already has nothing assigned.");

    apply(new UnAssignK1ecFromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignK2ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignK2ToExcELIN2Command");

    if (k2 != null && k2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK2ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK2FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK2FromExcELIN2Command");

    if (k2 == null) throw new ProcessingException("K2 already has nothing assigned.");

    apply(new UnAssignK2FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignK3ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignK3ToExcELIN2Command");

    if (k3 != null && k3.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K3 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK3ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK3FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK3FromExcELIN2Command");

    if (k3 == null) throw new ProcessingException("K3 already has nothing assigned.");

    apply(new UnAssignK3FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignK4ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignK4ToExcELIN2Command");

    if (k4 != null && k4.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K4 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignK4ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK4FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignK4FromExcELIN2Command");

    if (k4 == null) throw new ProcessingException("K4 already has nothing assigned.");

    apply(new UnAssignK4FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignKd1ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignKd1ToExcELIN2Command");

    if (kd1 != null && kd1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kd1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKd1ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKd1FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKd1FromExcELIN2Command");

    if (kd1 == null) throw new ProcessingException("Kd1 already has nothing assigned.");

    apply(new UnAssignKd1FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignKe2ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignKe2ToExcELIN2Command");

    if (ke2 != null && ke2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ke2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKe2ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKe2FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKe2FromExcELIN2Command");

    if (ke2 == null) throw new ProcessingException("Ke2 already has nothing assigned.");

    apply(new UnAssignKe2FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignKetbToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignKetbToExcELIN2Command");

    if (ketb != null && ketb.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ketb already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKetbToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKetbFromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKetbFromExcELIN2Command");

    if (ketb == null) throw new ProcessingException("Ketb already has nothing assigned.");

    apply(new UnAssignKetbFromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignPid1maxToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignPid1maxToExcELIN2Command");

    if (pid1max != null && pid1max.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pid1max already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignPid1maxToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPid1maxFromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignPid1maxFromExcELIN2Command");

    if (pid1max == null) throw new ProcessingException("Pid1max already has nothing assigned.");

    apply(new UnAssignPid1maxFromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignSeve1ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignSeve1ToExcELIN2Command");

    if (seve1 != null && seve1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Seve1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignSeve1ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve1FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve1FromExcELIN2Command");

    if (seve1 == null) throw new ProcessingException("Seve1 already has nothing assigned.");

    apply(new UnAssignSeve1FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignSeve2ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignSeve2ToExcELIN2Command");

    if (seve2 != null && seve2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Seve2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignSeve2ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSeve2FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSeve2FromExcELIN2Command");

    if (seve2 == null) throw new ProcessingException("Seve2 already has nothing assigned.");

    apply(new UnAssignSeve2FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignTb1ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignTb1ToExcELIN2Command");

    if (tb1 != null && tb1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTb1ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTb1FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTb1FromExcELIN2Command");

    if (tb1 == null) throw new ProcessingException("Tb1 already has nothing assigned.");

    apply(new UnAssignTb1FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignTeToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignTeToExcELIN2Command");

    if (te != null && te.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTeToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeFromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeFromExcELIN2Command");

    if (te == null) throw new ProcessingException("Te already has nothing assigned.");

    apply(new UnAssignTeFromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignTe2ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignTe2ToExcELIN2Command");

    if (te2 != null && te2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Te2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTe2ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTe2FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTe2FromExcELIN2Command");

    if (te2 == null) throw new ProcessingException("Te2 already has nothing assigned.");

    apply(new UnAssignTe2FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignTi1ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignTi1ToExcELIN2Command");

    if (ti1 != null && ti1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ti1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignTi1ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi1FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi1FromExcELIN2Command");

    if (ti1 == null) throw new ProcessingException("Ti1 already has nothing assigned.");

    apply(new UnAssignTi1FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignTi3ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignTi3ToExcELIN2Command");

    if (ti3 != null && ti3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTi3ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi3FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi3FromExcELIN2Command");

    if (ti3 == null) throw new ProcessingException("Ti3 already has nothing assigned.");

    apply(new UnAssignTi3FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignTi4ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignTi4ToExcELIN2Command");

    if (ti4 != null && ti4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTi4ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi4FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi4FromExcELIN2Command");

    if (ti4 == null) throw new ProcessingException("Ti4 already has nothing assigned.");

    apply(new UnAssignTi4FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignTr4ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignTr4ToExcELIN2Command");

    if (tr4 != null && tr4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tr4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTr4ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTr4FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTr4FromExcELIN2Command");

    if (tr4 == null) throw new ProcessingException("Tr4 already has nothing assigned.");

    apply(new UnAssignTr4FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignUpmaxToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignUpmaxToExcELIN2Command");

    if (upmax != null && upmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Upmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignUpmaxToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUpmaxFromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignUpmaxFromExcELIN2Command");

    if (upmax == null) throw new ProcessingException("Upmax already has nothing assigned.");

    apply(new UnAssignUpmaxFromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignUpminToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignUpminToExcELIN2Command");

    if (upmin != null && upmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Upmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignUpminToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUpminFromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignUpminFromExcELIN2Command");

    if (upmin == null) throw new ProcessingException("Upmin already has nothing assigned.");

    apply(new UnAssignUpminFromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignVe1ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignVe1ToExcELIN2Command");

    if (ve1 != null && ve1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe1ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe1FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe1FromExcELIN2Command");

    if (ve1 == null) throw new ProcessingException("Ve1 already has nothing assigned.");

    apply(new UnAssignVe1FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignVe2ToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignVe2ToExcELIN2Command");

    if (ve2 != null && ve2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ve2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVe2ToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVe2FromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVe2FromExcELIN2Command");

    if (ve2 == null) throw new ProcessingException("Ve2 already has nothing assigned.");

    apply(new UnAssignVe2FromExcELIN2Event(command.getExcELIN2Id()));
  }

  @CommandHandler
  public void handle(AssignXpToExcELIN2Command command) throws Exception {
    LOGGER.info("Handling command AssignXpToExcELIN2Command");

    if (xp != null && xp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignXpToExcELIN2Event(command.getExcELIN2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXpFromExcELIN2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignXpFromExcELIN2Command");

    if (xp == null) throw new ProcessingException("Xp already has nothing assigned.");

    apply(new UnAssignXpFromExcELIN2Event(command.getExcELIN2Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcELIN2Event event) {
    LOGGER.info("Event sourcing CreateExcELIN2Event");
    this.excELIN2Id = event.getExcELIN2Id();
  }

  @EventSourcingHandler
  void on(UpdateExcELIN2Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.efdbas = event.getEfdbas();
    this.iefmax = event.getIefmax();
    this.iefmax2 = event.getIefmax2();
    this.iefmin = event.getIefmin();
    this.k1 = event.getK1();
    this.k1ec = event.getK1ec();
    this.k2 = event.getK2();
    this.k3 = event.getK3();
    this.k4 = event.getK4();
    this.kd1 = event.getKd1();
    this.ke2 = event.getKe2();
    this.ketb = event.getKetb();
    this.pid1max = event.getPid1max();
    this.seve1 = event.getSeve1();
    this.seve2 = event.getSeve2();
    this.tb1 = event.getTb1();
    this.te = event.getTe();
    this.te2 = event.getTe2();
    this.ti1 = event.getTi1();
    this.ti3 = event.getTi3();
    this.ti4 = event.getTi4();
    this.tr4 = event.getTr4();
    this.upmax = event.getUpmax();
    this.upmin = event.getUpmin();
    this.ve1 = event.getVe1();
    this.ve2 = event.getVe2();
    this.xp = event.getXp();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEfdbasToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignEfdbasToExcELIN2Event");
    this.efdbas = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfdbasFromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignEfdbasFromExcELIN2Event");
    this.efdbas = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIefmaxToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignIefmaxToExcELIN2Event");
    this.iefmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIefmaxFromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignIefmaxFromExcELIN2Event");
    this.iefmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIefmax2ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignIefmax2ToExcELIN2Event");
    this.iefmax2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIefmax2FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignIefmax2FromExcELIN2Event");
    this.iefmax2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIefminToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignIefminToExcELIN2Event");
    this.iefmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIefminFromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignIefminFromExcELIN2Event");
    this.iefmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK1ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignK1ToExcELIN2Event");
    this.k1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignK1FromExcELIN2Event");
    this.k1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK1ecToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignK1ecToExcELIN2Event");
    this.k1ec = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK1ecFromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignK1ecFromExcELIN2Event");
    this.k1ec = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK2ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignK2ToExcELIN2Event");
    this.k2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK2FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignK2FromExcELIN2Event");
    this.k2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK3ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignK3ToExcELIN2Event");
    this.k3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK3FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignK3FromExcELIN2Event");
    this.k3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK4ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignK4ToExcELIN2Event");
    this.k4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK4FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignK4FromExcELIN2Event");
    this.k4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKd1ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignKd1ToExcELIN2Event");
    this.kd1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKd1FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignKd1FromExcELIN2Event");
    this.kd1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKe2ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignKe2ToExcELIN2Event");
    this.ke2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKe2FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignKe2FromExcELIN2Event");
    this.ke2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKetbToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignKetbToExcELIN2Event");
    this.ketb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKetbFromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignKetbFromExcELIN2Event");
    this.ketb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPid1maxToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignPid1maxToExcELIN2Event");
    this.pid1max = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPid1maxFromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignPid1maxFromExcELIN2Event");
    this.pid1max = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve1ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignSeve1ToExcELIN2Event");
    this.seve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve1FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignSeve1FromExcELIN2Event");
    this.seve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSeve2ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignSeve2ToExcELIN2Event");
    this.seve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSeve2FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignSeve2FromExcELIN2Event");
    this.seve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTb1ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignTb1ToExcELIN2Event");
    this.tb1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTb1FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignTb1FromExcELIN2Event");
    this.tb1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignTeToExcELIN2Event");
    this.te = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeFromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignTeFromExcELIN2Event");
    this.te = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTe2ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignTe2ToExcELIN2Event");
    this.te2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTe2FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignTe2FromExcELIN2Event");
    this.te2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi1ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignTi1ToExcELIN2Event");
    this.ti1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi1FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignTi1FromExcELIN2Event");
    this.ti1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi3ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignTi3ToExcELIN2Event");
    this.ti3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi3FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignTi3FromExcELIN2Event");
    this.ti3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi4ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignTi4ToExcELIN2Event");
    this.ti4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi4FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignTi4FromExcELIN2Event");
    this.ti4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTr4ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignTr4ToExcELIN2Event");
    this.tr4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTr4FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignTr4FromExcELIN2Event");
    this.tr4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUpmaxToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignUpmaxToExcELIN2Event");
    this.upmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUpmaxFromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignUpmaxFromExcELIN2Event");
    this.upmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUpminToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignUpminToExcELIN2Event");
    this.upmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUpminFromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignUpminFromExcELIN2Event");
    this.upmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe1ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignVe1ToExcELIN2Event");
    this.ve1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe1FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignVe1FromExcELIN2Event");
    this.ve1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVe2ToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignVe2ToExcELIN2Event");
    this.ve2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVe2FromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignVe2FromExcELIN2Event");
    this.ve2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXpToExcELIN2Event event) {
    LOGGER.info("Event sourcing AssignXpToExcELIN2Event");
    this.xp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXpFromExcELIN2Event event) {
    LOGGER.info("Event sourcing UnAssignXpFromExcELIN2Event");
    this.xp = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excELIN2Id;

  private PU efdbas = null;
  private PU iefmax = null;
  private PU iefmax2 = null;
  private PU iefmin = null;
  private PU k1 = null;
  private PU k1ec = null;
  private PU k2 = null;
  private PU k3 = null;
  private PU k4 = null;
  private PU kd1 = null;
  private PU ke2 = null;
  private PU ketb = null;
  private PU pid1max = null;
  private PU seve1 = null;
  private PU seve2 = null;
  private Seconds tb1 = null;
  private Seconds te = null;
  private Seconds te2 = null;
  private PU ti1 = null;
  private Seconds ti3 = null;
  private Seconds ti4 = null;
  private Seconds tr4 = null;
  private PU upmax = null;
  private PU upmin = null;
  private PU ve1 = null;
  private PU ve2 = null;
  private PU xp = null;

  private static final Logger LOGGER = Logger.getLogger(ExcELIN2Aggregate.class.getName());
}
