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
 * Aggregate handler for PssIEEE4B as outlined for the CQRS pattern, all write responsibilities
 * related to PssIEEE4B are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class PssIEEE4BAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public PssIEEE4BAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public PssIEEE4BAggregate(CreatePssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command CreatePssIEEE4BCommand");
    CreatePssIEEE4BEvent event = new CreatePssIEEE4BEvent(command.getPssIEEE4BId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdatePssIEEE4BCommand command) throws Exception {
    LOGGER.info("handling command UpdatePssIEEE4BCommand");
    UpdatePssIEEE4BEvent event =
        new UpdatePssIEEE4BEvent(
            command.getPssIEEE4BId(),
            command.getBwh1(),
            command.getBwh2(),
            command.getBwl1(),
            command.getBwl2(),
            command.getKh(),
            command.getKh1(),
            command.getKh11(),
            command.getKh17(),
            command.getKh2(),
            command.getKi(),
            command.getKi1(),
            command.getKi11(),
            command.getKi17(),
            command.getKi2(),
            command.getKl(),
            command.getKl1(),
            command.getKl11(),
            command.getKl17(),
            command.getKl2(),
            command.getOmeganh1(),
            command.getOmeganh2(),
            command.getOmeganl1(),
            command.getOmeganl2(),
            command.getTh1(),
            command.getTh10(),
            command.getTh11(),
            command.getTh12(),
            command.getTh2(),
            command.getTh3(),
            command.getTh4(),
            command.getTh5(),
            command.getTh6(),
            command.getTh7(),
            command.getTh8(),
            command.getTh9(),
            command.getTi1(),
            command.getTi10(),
            command.getTi11(),
            command.getTi12(),
            command.getTi2(),
            command.getTi3(),
            command.getTi4(),
            command.getTi5(),
            command.getTi6(),
            command.getTi7(),
            command.getTi8(),
            command.getTi9(),
            command.getTl1(),
            command.getTl10(),
            command.getTl11(),
            command.getTl12(),
            command.getTl2(),
            command.getTl3(),
            command.getTl4(),
            command.getTl5(),
            command.getTl6(),
            command.getTl7(),
            command.getTl8(),
            command.getTl9(),
            command.getVhmax(),
            command.getVhmin(),
            command.getVimax(),
            command.getVimin(),
            command.getVlmax(),
            command.getVlmin(),
            command.getVstmax(),
            command.getVstmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeletePssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command DeletePssIEEE4BCommand");
    apply(new DeletePssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBwh1ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignBwh1ToPssIEEE4BCommand");

    if (bwh1 != null && bwh1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Bwh1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignBwh1ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBwh1FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBwh1FromPssIEEE4BCommand");

    if (bwh1 == null) throw new ProcessingException("Bwh1 already has nothing assigned.");

    apply(new UnAssignBwh1FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignBwh2ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignBwh2ToPssIEEE4BCommand");

    if (bwh2 != null && bwh2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Bwh2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignBwh2ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBwh2FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBwh2FromPssIEEE4BCommand");

    if (bwh2 == null) throw new ProcessingException("Bwh2 already has nothing assigned.");

    apply(new UnAssignBwh2FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignBwl1ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignBwl1ToPssIEEE4BCommand");

    if (bwl1 != null && bwl1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Bwl1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignBwl1ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBwl1FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBwl1FromPssIEEE4BCommand");

    if (bwl1 == null) throw new ProcessingException("Bwl1 already has nothing assigned.");

    apply(new UnAssignBwl1FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignBwl2ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignBwl2ToPssIEEE4BCommand");

    if (bwl2 != null && bwl2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Bwl2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignBwl2ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBwl2FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBwl2FromPssIEEE4BCommand");

    if (bwl2 == null) throw new ProcessingException("Bwl2 already has nothing assigned.");

    apply(new UnAssignBwl2FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKhToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKhToPssIEEE4BCommand");

    if (kh != null && kh.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kh already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKhToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKhFromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKhFromPssIEEE4BCommand");

    if (kh == null) throw new ProcessingException("Kh already has nothing assigned.");

    apply(new UnAssignKhFromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKh1ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKh1ToPssIEEE4BCommand");

    if (kh1 != null && kh1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kh1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKh1ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKh1FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKh1FromPssIEEE4BCommand");

    if (kh1 == null) throw new ProcessingException("Kh1 already has nothing assigned.");

    apply(new UnAssignKh1FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKh11ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKh11ToPssIEEE4BCommand");

    if (kh11 != null && kh11.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kh11 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKh11ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKh11FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKh11FromPssIEEE4BCommand");

    if (kh11 == null) throw new ProcessingException("Kh11 already has nothing assigned.");

    apply(new UnAssignKh11FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKh17ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKh17ToPssIEEE4BCommand");

    if (kh17 != null && kh17.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kh17 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKh17ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKh17FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKh17FromPssIEEE4BCommand");

    if (kh17 == null) throw new ProcessingException("Kh17 already has nothing assigned.");

    apply(new UnAssignKh17FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKh2ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKh2ToPssIEEE4BCommand");

    if (kh2 != null && kh2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kh2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKh2ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKh2FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKh2FromPssIEEE4BCommand");

    if (kh2 == null) throw new ProcessingException("Kh2 already has nothing assigned.");

    apply(new UnAssignKh2FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKiToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiToPssIEEE4BCommand");

    if (ki != null && ki.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiFromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiFromPssIEEE4BCommand");

    if (ki == null) throw new ProcessingException("Ki already has nothing assigned.");

    apply(new UnAssignKiFromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKi1ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKi1ToPssIEEE4BCommand");

    if (ki1 != null && ki1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKi1ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKi1FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKi1FromPssIEEE4BCommand");

    if (ki1 == null) throw new ProcessingException("Ki1 already has nothing assigned.");

    apply(new UnAssignKi1FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKi11ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKi11ToPssIEEE4BCommand");

    if (ki11 != null && ki11.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki11 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKi11ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKi11FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKi11FromPssIEEE4BCommand");

    if (ki11 == null) throw new ProcessingException("Ki11 already has nothing assigned.");

    apply(new UnAssignKi11FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKi17ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKi17ToPssIEEE4BCommand");

    if (ki17 != null && ki17.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki17 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKi17ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKi17FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKi17FromPssIEEE4BCommand");

    if (ki17 == null) throw new ProcessingException("Ki17 already has nothing assigned.");

    apply(new UnAssignKi17FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKi2ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKi2ToPssIEEE4BCommand");

    if (ki2 != null && ki2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ki2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKi2ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKi2FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKi2FromPssIEEE4BCommand");

    if (ki2 == null) throw new ProcessingException("Ki2 already has nothing assigned.");

    apply(new UnAssignKi2FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKlToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKlToPssIEEE4BCommand");

    if (kl != null && kl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kl already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKlToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKlFromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKlFromPssIEEE4BCommand");

    if (kl == null) throw new ProcessingException("Kl already has nothing assigned.");

    apply(new UnAssignKlFromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKl1ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKl1ToPssIEEE4BCommand");

    if (kl1 != null && kl1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kl1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKl1ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKl1FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKl1FromPssIEEE4BCommand");

    if (kl1 == null) throw new ProcessingException("Kl1 already has nothing assigned.");

    apply(new UnAssignKl1FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKl11ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKl11ToPssIEEE4BCommand");

    if (kl11 != null && kl11.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kl11 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKl11ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKl11FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKl11FromPssIEEE4BCommand");

    if (kl11 == null) throw new ProcessingException("Kl11 already has nothing assigned.");

    apply(new UnAssignKl11FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKl17ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKl17ToPssIEEE4BCommand");

    if (kl17 != null && kl17.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kl17 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKl17ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKl17FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKl17FromPssIEEE4BCommand");

    if (kl17 == null) throw new ProcessingException("Kl17 already has nothing assigned.");

    apply(new UnAssignKl17FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignKl2ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignKl2ToPssIEEE4BCommand");

    if (kl2 != null && kl2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kl2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKl2ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKl2FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKl2FromPssIEEE4BCommand");

    if (kl2 == null) throw new ProcessingException("Kl2 already has nothing assigned.");

    apply(new UnAssignKl2FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignOmeganh1ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignOmeganh1ToPssIEEE4BCommand");

    if (omeganh1 != null
        && omeganh1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Omeganh1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignOmeganh1ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOmeganh1FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignOmeganh1FromPssIEEE4BCommand");

    if (omeganh1 == null) throw new ProcessingException("Omeganh1 already has nothing assigned.");

    apply(new UnAssignOmeganh1FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignOmeganh2ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignOmeganh2ToPssIEEE4BCommand");

    if (omeganh2 != null
        && omeganh2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Omeganh2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignOmeganh2ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOmeganh2FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignOmeganh2FromPssIEEE4BCommand");

    if (omeganh2 == null) throw new ProcessingException("Omeganh2 already has nothing assigned.");

    apply(new UnAssignOmeganh2FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignOmeganl1ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignOmeganl1ToPssIEEE4BCommand");

    if (omeganl1 != null
        && omeganl1.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Omeganl1 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignOmeganl1ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOmeganl1FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignOmeganl1FromPssIEEE4BCommand");

    if (omeganl1 == null) throw new ProcessingException("Omeganl1 already has nothing assigned.");

    apply(new UnAssignOmeganl1FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignOmeganl2ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignOmeganl2ToPssIEEE4BCommand");

    if (omeganl2 != null
        && omeganl2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Omeganl2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignOmeganl2ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOmeganl2FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignOmeganl2FromPssIEEE4BCommand");

    if (omeganl2 == null) throw new ProcessingException("Omeganl2 already has nothing assigned.");

    apply(new UnAssignOmeganl2FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTh1ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTh1ToPssIEEE4BCommand");

    if (th1 != null && th1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Th1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTh1ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTh1FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTh1FromPssIEEE4BCommand");

    if (th1 == null) throw new ProcessingException("Th1 already has nothing assigned.");

    apply(new UnAssignTh1FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTh10ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTh10ToPssIEEE4BCommand");

    if (th10 != null && th10.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Th10 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTh10ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTh10FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTh10FromPssIEEE4BCommand");

    if (th10 == null) throw new ProcessingException("Th10 already has nothing assigned.");

    apply(new UnAssignTh10FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTh11ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTh11ToPssIEEE4BCommand");

    if (th11 != null && th11.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Th11 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTh11ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTh11FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTh11FromPssIEEE4BCommand");

    if (th11 == null) throw new ProcessingException("Th11 already has nothing assigned.");

    apply(new UnAssignTh11FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTh12ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTh12ToPssIEEE4BCommand");

    if (th12 != null && th12.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Th12 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTh12ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTh12FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTh12FromPssIEEE4BCommand");

    if (th12 == null) throw new ProcessingException("Th12 already has nothing assigned.");

    apply(new UnAssignTh12FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTh2ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTh2ToPssIEEE4BCommand");

    if (th2 != null && th2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Th2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTh2ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTh2FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTh2FromPssIEEE4BCommand");

    if (th2 == null) throw new ProcessingException("Th2 already has nothing assigned.");

    apply(new UnAssignTh2FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTh3ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTh3ToPssIEEE4BCommand");

    if (th3 != null && th3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Th3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTh3ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTh3FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTh3FromPssIEEE4BCommand");

    if (th3 == null) throw new ProcessingException("Th3 already has nothing assigned.");

    apply(new UnAssignTh3FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTh4ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTh4ToPssIEEE4BCommand");

    if (th4 != null && th4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Th4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTh4ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTh4FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTh4FromPssIEEE4BCommand");

    if (th4 == null) throw new ProcessingException("Th4 already has nothing assigned.");

    apply(new UnAssignTh4FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTh5ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTh5ToPssIEEE4BCommand");

    if (th5 != null && th5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Th5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTh5ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTh5FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTh5FromPssIEEE4BCommand");

    if (th5 == null) throw new ProcessingException("Th5 already has nothing assigned.");

    apply(new UnAssignTh5FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTh6ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTh6ToPssIEEE4BCommand");

    if (th6 != null && th6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Th6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTh6ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTh6FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTh6FromPssIEEE4BCommand");

    if (th6 == null) throw new ProcessingException("Th6 already has nothing assigned.");

    apply(new UnAssignTh6FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTh7ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTh7ToPssIEEE4BCommand");

    if (th7 != null && th7.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Th7 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTh7ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTh7FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTh7FromPssIEEE4BCommand");

    if (th7 == null) throw new ProcessingException("Th7 already has nothing assigned.");

    apply(new UnAssignTh7FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTh8ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTh8ToPssIEEE4BCommand");

    if (th8 != null && th8.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Th8 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTh8ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTh8FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTh8FromPssIEEE4BCommand");

    if (th8 == null) throw new ProcessingException("Th8 already has nothing assigned.");

    apply(new UnAssignTh8FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTh9ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTh9ToPssIEEE4BCommand");

    if (th9 != null && th9.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Th9 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTh9ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTh9FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTh9FromPssIEEE4BCommand");

    if (th9 == null) throw new ProcessingException("Th9 already has nothing assigned.");

    apply(new UnAssignTh9FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTi1ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTi1ToPssIEEE4BCommand");

    if (ti1 != null && ti1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTi1ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi1FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi1FromPssIEEE4BCommand");

    if (ti1 == null) throw new ProcessingException("Ti1 already has nothing assigned.");

    apply(new UnAssignTi1FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTi10ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTi10ToPssIEEE4BCommand");

    if (ti10 != null && ti10.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti10 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTi10ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi10FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi10FromPssIEEE4BCommand");

    if (ti10 == null) throw new ProcessingException("Ti10 already has nothing assigned.");

    apply(new UnAssignTi10FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTi11ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTi11ToPssIEEE4BCommand");

    if (ti11 != null && ti11.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti11 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTi11ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi11FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi11FromPssIEEE4BCommand");

    if (ti11 == null) throw new ProcessingException("Ti11 already has nothing assigned.");

    apply(new UnAssignTi11FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTi12ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTi12ToPssIEEE4BCommand");

    if (ti12 != null && ti12.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti12 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTi12ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi12FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi12FromPssIEEE4BCommand");

    if (ti12 == null) throw new ProcessingException("Ti12 already has nothing assigned.");

    apply(new UnAssignTi12FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTi2ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTi2ToPssIEEE4BCommand");

    if (ti2 != null && ti2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTi2ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi2FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi2FromPssIEEE4BCommand");

    if (ti2 == null) throw new ProcessingException("Ti2 already has nothing assigned.");

    apply(new UnAssignTi2FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTi3ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTi3ToPssIEEE4BCommand");

    if (ti3 != null && ti3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTi3ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi3FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi3FromPssIEEE4BCommand");

    if (ti3 == null) throw new ProcessingException("Ti3 already has nothing assigned.");

    apply(new UnAssignTi3FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTi4ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTi4ToPssIEEE4BCommand");

    if (ti4 != null && ti4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTi4ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi4FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi4FromPssIEEE4BCommand");

    if (ti4 == null) throw new ProcessingException("Ti4 already has nothing assigned.");

    apply(new UnAssignTi4FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTi5ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTi5ToPssIEEE4BCommand");

    if (ti5 != null && ti5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTi5ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi5FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi5FromPssIEEE4BCommand");

    if (ti5 == null) throw new ProcessingException("Ti5 already has nothing assigned.");

    apply(new UnAssignTi5FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTi6ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTi6ToPssIEEE4BCommand");

    if (ti6 != null && ti6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTi6ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi6FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi6FromPssIEEE4BCommand");

    if (ti6 == null) throw new ProcessingException("Ti6 already has nothing assigned.");

    apply(new UnAssignTi6FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTi7ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTi7ToPssIEEE4BCommand");

    if (ti7 != null && ti7.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti7 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTi7ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi7FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi7FromPssIEEE4BCommand");

    if (ti7 == null) throw new ProcessingException("Ti7 already has nothing assigned.");

    apply(new UnAssignTi7FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTi8ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTi8ToPssIEEE4BCommand");

    if (ti8 != null && ti8.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti8 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTi8ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi8FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi8FromPssIEEE4BCommand");

    if (ti8 == null) throw new ProcessingException("Ti8 already has nothing assigned.");

    apply(new UnAssignTi8FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTi9ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTi9ToPssIEEE4BCommand");

    if (ti9 != null && ti9.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ti9 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTi9ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTi9FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTi9FromPssIEEE4BCommand");

    if (ti9 == null) throw new ProcessingException("Ti9 already has nothing assigned.");

    apply(new UnAssignTi9FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTl1ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTl1ToPssIEEE4BCommand");

    if (tl1 != null && tl1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl1ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl1FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl1FromPssIEEE4BCommand");

    if (tl1 == null) throw new ProcessingException("Tl1 already has nothing assigned.");

    apply(new UnAssignTl1FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTl10ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTl10ToPssIEEE4BCommand");

    if (tl10 != null && tl10.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl10 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl10ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl10FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl10FromPssIEEE4BCommand");

    if (tl10 == null) throw new ProcessingException("Tl10 already has nothing assigned.");

    apply(new UnAssignTl10FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTl11ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTl11ToPssIEEE4BCommand");

    if (tl11 != null && tl11.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl11 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl11ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl11FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl11FromPssIEEE4BCommand");

    if (tl11 == null) throw new ProcessingException("Tl11 already has nothing assigned.");

    apply(new UnAssignTl11FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTl12ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTl12ToPssIEEE4BCommand");

    if (tl12 != null && tl12.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl12 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl12ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl12FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl12FromPssIEEE4BCommand");

    if (tl12 == null) throw new ProcessingException("Tl12 already has nothing assigned.");

    apply(new UnAssignTl12FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTl2ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTl2ToPssIEEE4BCommand");

    if (tl2 != null && tl2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl2ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl2FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl2FromPssIEEE4BCommand");

    if (tl2 == null) throw new ProcessingException("Tl2 already has nothing assigned.");

    apply(new UnAssignTl2FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTl3ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTl3ToPssIEEE4BCommand");

    if (tl3 != null && tl3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl3ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl3FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl3FromPssIEEE4BCommand");

    if (tl3 == null) throw new ProcessingException("Tl3 already has nothing assigned.");

    apply(new UnAssignTl3FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTl4ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTl4ToPssIEEE4BCommand");

    if (tl4 != null && tl4.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl4 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl4ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl4FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl4FromPssIEEE4BCommand");

    if (tl4 == null) throw new ProcessingException("Tl4 already has nothing assigned.");

    apply(new UnAssignTl4FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTl5ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTl5ToPssIEEE4BCommand");

    if (tl5 != null && tl5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl5ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl5FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl5FromPssIEEE4BCommand");

    if (tl5 == null) throw new ProcessingException("Tl5 already has nothing assigned.");

    apply(new UnAssignTl5FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTl6ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTl6ToPssIEEE4BCommand");

    if (tl6 != null && tl6.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl6 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl6ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl6FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl6FromPssIEEE4BCommand");

    if (tl6 == null) throw new ProcessingException("Tl6 already has nothing assigned.");

    apply(new UnAssignTl6FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTl7ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTl7ToPssIEEE4BCommand");

    if (tl7 != null && tl7.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl7 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl7ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl7FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl7FromPssIEEE4BCommand");

    if (tl7 == null) throw new ProcessingException("Tl7 already has nothing assigned.");

    apply(new UnAssignTl7FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTl8ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTl8ToPssIEEE4BCommand");

    if (tl8 != null && tl8.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl8 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl8ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl8FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl8FromPssIEEE4BCommand");

    if (tl8 == null) throw new ProcessingException("Tl8 already has nothing assigned.");

    apply(new UnAssignTl8FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignTl9ToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignTl9ToPssIEEE4BCommand");

    if (tl9 != null && tl9.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl9 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTl9ToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl9FromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl9FromPssIEEE4BCommand");

    if (tl9 == null) throw new ProcessingException("Tl9 already has nothing assigned.");

    apply(new UnAssignTl9FromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignVhmaxToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVhmaxToPssIEEE4BCommand");

    if (vhmax != null && vhmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vhmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVhmaxToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVhmaxFromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVhmaxFromPssIEEE4BCommand");

    if (vhmax == null) throw new ProcessingException("Vhmax already has nothing assigned.");

    apply(new UnAssignVhmaxFromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignVhminToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVhminToPssIEEE4BCommand");

    if (vhmin != null && vhmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vhmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVhminToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVhminFromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVhminFromPssIEEE4BCommand");

    if (vhmin == null) throw new ProcessingException("Vhmin already has nothing assigned.");

    apply(new UnAssignVhminFromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignVimaxToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVimaxToPssIEEE4BCommand");

    if (vimax != null && vimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVimaxToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVimaxFromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVimaxFromPssIEEE4BCommand");

    if (vimax == null) throw new ProcessingException("Vimax already has nothing assigned.");

    apply(new UnAssignVimaxFromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignViminToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignViminToPssIEEE4BCommand");

    if (vimin != null && vimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vimin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignViminToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignViminFromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignViminFromPssIEEE4BCommand");

    if (vimin == null) throw new ProcessingException("Vimin already has nothing assigned.");

    apply(new UnAssignViminFromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignVlmaxToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVlmaxToPssIEEE4BCommand");

    if (vlmax != null && vlmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vlmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVlmaxToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVlmaxFromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVlmaxFromPssIEEE4BCommand");

    if (vlmax == null) throw new ProcessingException("Vlmax already has nothing assigned.");

    apply(new UnAssignVlmaxFromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignVlminToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVlminToPssIEEE4BCommand");

    if (vlmin != null && vlmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vlmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVlminToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVlminFromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVlminFromPssIEEE4BCommand");

    if (vlmin == null) throw new ProcessingException("Vlmin already has nothing assigned.");

    apply(new UnAssignVlminFromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignVstmaxToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVstmaxToPssIEEE4BCommand");

    if (vstmax != null && vstmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vstmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVstmaxToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVstmaxFromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVstmaxFromPssIEEE4BCommand");

    if (vstmax == null) throw new ProcessingException("Vstmax already has nothing assigned.");

    apply(new UnAssignVstmaxFromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  @CommandHandler
  public void handle(AssignVstminToPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handling command AssignVstminToPssIEEE4BCommand");

    if (vstmin != null && vstmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vstmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVstminToPssIEEE4BEvent(command.getPssIEEE4BId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVstminFromPssIEEE4BCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVstminFromPssIEEE4BCommand");

    if (vstmin == null) throw new ProcessingException("Vstmin already has nothing assigned.");

    apply(new UnAssignVstminFromPssIEEE4BEvent(command.getPssIEEE4BId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreatePssIEEE4BEvent event) {
    LOGGER.info("Event sourcing CreatePssIEEE4BEvent");
    this.pssIEEE4BId = event.getPssIEEE4BId();
  }

  @EventSourcingHandler
  void on(UpdatePssIEEE4BEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.bwh1 = event.getBwh1();
    this.bwh2 = event.getBwh2();
    this.bwl1 = event.getBwl1();
    this.bwl2 = event.getBwl2();
    this.kh = event.getKh();
    this.kh1 = event.getKh1();
    this.kh11 = event.getKh11();
    this.kh17 = event.getKh17();
    this.kh2 = event.getKh2();
    this.ki = event.getKi();
    this.ki1 = event.getKi1();
    this.ki11 = event.getKi11();
    this.ki17 = event.getKi17();
    this.ki2 = event.getKi2();
    this.kl = event.getKl();
    this.kl1 = event.getKl1();
    this.kl11 = event.getKl11();
    this.kl17 = event.getKl17();
    this.kl2 = event.getKl2();
    this.omeganh1 = event.getOmeganh1();
    this.omeganh2 = event.getOmeganh2();
    this.omeganl1 = event.getOmeganl1();
    this.omeganl2 = event.getOmeganl2();
    this.th1 = event.getTh1();
    this.th10 = event.getTh10();
    this.th11 = event.getTh11();
    this.th12 = event.getTh12();
    this.th2 = event.getTh2();
    this.th3 = event.getTh3();
    this.th4 = event.getTh4();
    this.th5 = event.getTh5();
    this.th6 = event.getTh6();
    this.th7 = event.getTh7();
    this.th8 = event.getTh8();
    this.th9 = event.getTh9();
    this.ti1 = event.getTi1();
    this.ti10 = event.getTi10();
    this.ti11 = event.getTi11();
    this.ti12 = event.getTi12();
    this.ti2 = event.getTi2();
    this.ti3 = event.getTi3();
    this.ti4 = event.getTi4();
    this.ti5 = event.getTi5();
    this.ti6 = event.getTi6();
    this.ti7 = event.getTi7();
    this.ti8 = event.getTi8();
    this.ti9 = event.getTi9();
    this.tl1 = event.getTl1();
    this.tl10 = event.getTl10();
    this.tl11 = event.getTl11();
    this.tl12 = event.getTl12();
    this.tl2 = event.getTl2();
    this.tl3 = event.getTl3();
    this.tl4 = event.getTl4();
    this.tl5 = event.getTl5();
    this.tl6 = event.getTl6();
    this.tl7 = event.getTl7();
    this.tl8 = event.getTl8();
    this.tl9 = event.getTl9();
    this.vhmax = event.getVhmax();
    this.vhmin = event.getVhmin();
    this.vimax = event.getVimax();
    this.vimin = event.getVimin();
    this.vlmax = event.getVlmax();
    this.vlmin = event.getVlmin();
    this.vstmax = event.getVstmax();
    this.vstmin = event.getVstmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBwh1ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignBwh1ToPssIEEE4BEvent");
    this.bwh1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBwh1FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignBwh1FromPssIEEE4BEvent");
    this.bwh1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBwh2ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignBwh2ToPssIEEE4BEvent");
    this.bwh2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBwh2FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignBwh2FromPssIEEE4BEvent");
    this.bwh2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBwl1ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignBwl1ToPssIEEE4BEvent");
    this.bwl1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBwl1FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignBwl1FromPssIEEE4BEvent");
    this.bwl1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBwl2ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignBwl2ToPssIEEE4BEvent");
    this.bwl2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBwl2FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignBwl2FromPssIEEE4BEvent");
    this.bwl2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKhToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKhToPssIEEE4BEvent");
    this.kh = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKhFromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKhFromPssIEEE4BEvent");
    this.kh = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKh1ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKh1ToPssIEEE4BEvent");
    this.kh1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKh1FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKh1FromPssIEEE4BEvent");
    this.kh1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKh11ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKh11ToPssIEEE4BEvent");
    this.kh11 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKh11FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKh11FromPssIEEE4BEvent");
    this.kh11 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKh17ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKh17ToPssIEEE4BEvent");
    this.kh17 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKh17FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKh17FromPssIEEE4BEvent");
    this.kh17 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKh2ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKh2ToPssIEEE4BEvent");
    this.kh2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKh2FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKh2FromPssIEEE4BEvent");
    this.kh2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKiToPssIEEE4BEvent");
    this.ki = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiFromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKiFromPssIEEE4BEvent");
    this.ki = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKi1ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKi1ToPssIEEE4BEvent");
    this.ki1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKi1FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKi1FromPssIEEE4BEvent");
    this.ki1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKi11ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKi11ToPssIEEE4BEvent");
    this.ki11 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKi11FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKi11FromPssIEEE4BEvent");
    this.ki11 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKi17ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKi17ToPssIEEE4BEvent");
    this.ki17 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKi17FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKi17FromPssIEEE4BEvent");
    this.ki17 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKi2ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKi2ToPssIEEE4BEvent");
    this.ki2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKi2FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKi2FromPssIEEE4BEvent");
    this.ki2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKlToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKlToPssIEEE4BEvent");
    this.kl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKlFromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKlFromPssIEEE4BEvent");
    this.kl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKl1ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKl1ToPssIEEE4BEvent");
    this.kl1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKl1FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKl1FromPssIEEE4BEvent");
    this.kl1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKl11ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKl11ToPssIEEE4BEvent");
    this.kl11 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKl11FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKl11FromPssIEEE4BEvent");
    this.kl11 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKl17ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKl17ToPssIEEE4BEvent");
    this.kl17 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKl17FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKl17FromPssIEEE4BEvent");
    this.kl17 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKl2ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignKl2ToPssIEEE4BEvent");
    this.kl2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKl2FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignKl2FromPssIEEE4BEvent");
    this.kl2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOmeganh1ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignOmeganh1ToPssIEEE4BEvent");
    this.omeganh1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOmeganh1FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignOmeganh1FromPssIEEE4BEvent");
    this.omeganh1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOmeganh2ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignOmeganh2ToPssIEEE4BEvent");
    this.omeganh2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOmeganh2FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignOmeganh2FromPssIEEE4BEvent");
    this.omeganh2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOmeganl1ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignOmeganl1ToPssIEEE4BEvent");
    this.omeganl1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOmeganl1FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignOmeganl1FromPssIEEE4BEvent");
    this.omeganl1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOmeganl2ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignOmeganl2ToPssIEEE4BEvent");
    this.omeganl2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOmeganl2FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignOmeganl2FromPssIEEE4BEvent");
    this.omeganl2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTh1ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTh1ToPssIEEE4BEvent");
    this.th1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTh1FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTh1FromPssIEEE4BEvent");
    this.th1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTh10ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTh10ToPssIEEE4BEvent");
    this.th10 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTh10FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTh10FromPssIEEE4BEvent");
    this.th10 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTh11ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTh11ToPssIEEE4BEvent");
    this.th11 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTh11FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTh11FromPssIEEE4BEvent");
    this.th11 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTh12ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTh12ToPssIEEE4BEvent");
    this.th12 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTh12FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTh12FromPssIEEE4BEvent");
    this.th12 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTh2ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTh2ToPssIEEE4BEvent");
    this.th2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTh2FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTh2FromPssIEEE4BEvent");
    this.th2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTh3ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTh3ToPssIEEE4BEvent");
    this.th3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTh3FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTh3FromPssIEEE4BEvent");
    this.th3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTh4ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTh4ToPssIEEE4BEvent");
    this.th4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTh4FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTh4FromPssIEEE4BEvent");
    this.th4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTh5ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTh5ToPssIEEE4BEvent");
    this.th5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTh5FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTh5FromPssIEEE4BEvent");
    this.th5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTh6ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTh6ToPssIEEE4BEvent");
    this.th6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTh6FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTh6FromPssIEEE4BEvent");
    this.th6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTh7ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTh7ToPssIEEE4BEvent");
    this.th7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTh7FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTh7FromPssIEEE4BEvent");
    this.th7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTh8ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTh8ToPssIEEE4BEvent");
    this.th8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTh8FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTh8FromPssIEEE4BEvent");
    this.th8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTh9ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTh9ToPssIEEE4BEvent");
    this.th9 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTh9FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTh9FromPssIEEE4BEvent");
    this.th9 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi1ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTi1ToPssIEEE4BEvent");
    this.ti1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi1FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTi1FromPssIEEE4BEvent");
    this.ti1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi10ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTi10ToPssIEEE4BEvent");
    this.ti10 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi10FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTi10FromPssIEEE4BEvent");
    this.ti10 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi11ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTi11ToPssIEEE4BEvent");
    this.ti11 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi11FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTi11FromPssIEEE4BEvent");
    this.ti11 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi12ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTi12ToPssIEEE4BEvent");
    this.ti12 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi12FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTi12FromPssIEEE4BEvent");
    this.ti12 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi2ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTi2ToPssIEEE4BEvent");
    this.ti2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi2FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTi2FromPssIEEE4BEvent");
    this.ti2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi3ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTi3ToPssIEEE4BEvent");
    this.ti3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi3FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTi3FromPssIEEE4BEvent");
    this.ti3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi4ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTi4ToPssIEEE4BEvent");
    this.ti4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi4FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTi4FromPssIEEE4BEvent");
    this.ti4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi5ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTi5ToPssIEEE4BEvent");
    this.ti5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi5FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTi5FromPssIEEE4BEvent");
    this.ti5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi6ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTi6ToPssIEEE4BEvent");
    this.ti6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi6FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTi6FromPssIEEE4BEvent");
    this.ti6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi7ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTi7ToPssIEEE4BEvent");
    this.ti7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi7FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTi7FromPssIEEE4BEvent");
    this.ti7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi8ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTi8ToPssIEEE4BEvent");
    this.ti8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi8FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTi8FromPssIEEE4BEvent");
    this.ti8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTi9ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTi9ToPssIEEE4BEvent");
    this.ti9 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTi9FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTi9FromPssIEEE4BEvent");
    this.ti9 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl1ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTl1ToPssIEEE4BEvent");
    this.tl1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl1FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTl1FromPssIEEE4BEvent");
    this.tl1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl10ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTl10ToPssIEEE4BEvent");
    this.tl10 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl10FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTl10FromPssIEEE4BEvent");
    this.tl10 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl11ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTl11ToPssIEEE4BEvent");
    this.tl11 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl11FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTl11FromPssIEEE4BEvent");
    this.tl11 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl12ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTl12ToPssIEEE4BEvent");
    this.tl12 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl12FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTl12FromPssIEEE4BEvent");
    this.tl12 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl2ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTl2ToPssIEEE4BEvent");
    this.tl2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl2FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTl2FromPssIEEE4BEvent");
    this.tl2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl3ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTl3ToPssIEEE4BEvent");
    this.tl3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl3FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTl3FromPssIEEE4BEvent");
    this.tl3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl4ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTl4ToPssIEEE4BEvent");
    this.tl4 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl4FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTl4FromPssIEEE4BEvent");
    this.tl4 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl5ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTl5ToPssIEEE4BEvent");
    this.tl5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl5FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTl5FromPssIEEE4BEvent");
    this.tl5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl6ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTl6ToPssIEEE4BEvent");
    this.tl6 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl6FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTl6FromPssIEEE4BEvent");
    this.tl6 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl7ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTl7ToPssIEEE4BEvent");
    this.tl7 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl7FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTl7FromPssIEEE4BEvent");
    this.tl7 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl8ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTl8ToPssIEEE4BEvent");
    this.tl8 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl8FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTl8FromPssIEEE4BEvent");
    this.tl8 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl9ToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignTl9ToPssIEEE4BEvent");
    this.tl9 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl9FromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignTl9FromPssIEEE4BEvent");
    this.tl9 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVhmaxToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignVhmaxToPssIEEE4BEvent");
    this.vhmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVhmaxFromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVhmaxFromPssIEEE4BEvent");
    this.vhmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVhminToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignVhminToPssIEEE4BEvent");
    this.vhmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVhminFromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVhminFromPssIEEE4BEvent");
    this.vhmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVimaxToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignVimaxToPssIEEE4BEvent");
    this.vimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVimaxFromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVimaxFromPssIEEE4BEvent");
    this.vimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignViminToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignViminToPssIEEE4BEvent");
    this.vimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignViminFromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignViminFromPssIEEE4BEvent");
    this.vimin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVlmaxToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignVlmaxToPssIEEE4BEvent");
    this.vlmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVlmaxFromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVlmaxFromPssIEEE4BEvent");
    this.vlmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVlminToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignVlminToPssIEEE4BEvent");
    this.vlmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVlminFromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVlminFromPssIEEE4BEvent");
    this.vlmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVstmaxToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignVstmaxToPssIEEE4BEvent");
    this.vstmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVstmaxFromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVstmaxFromPssIEEE4BEvent");
    this.vstmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVstminToPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing AssignVstminToPssIEEE4BEvent");
    this.vstmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVstminFromPssIEEE4BEvent event) {
    LOGGER.info("Event sourcing UnAssignVstminFromPssIEEE4BEvent");
    this.vstmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID pssIEEE4BId;

  private Simple_Float bwh1 = null;
  private Simple_Float bwh2 = null;
  private Simple_Float bwl1 = null;
  private Simple_Float bwl2 = null;
  private PU kh = null;
  private PU kh1 = null;
  private PU kh11 = null;
  private PU kh17 = null;
  private PU kh2 = null;
  private PU ki = null;
  private PU ki1 = null;
  private PU ki11 = null;
  private PU ki17 = null;
  private PU ki2 = null;
  private PU kl = null;
  private PU kl1 = null;
  private PU kl11 = null;
  private PU kl17 = null;
  private PU kl2 = null;
  private Simple_Float omeganh1 = null;
  private Simple_Float omeganh2 = null;
  private Simple_Float omeganl1 = null;
  private Simple_Float omeganl2 = null;
  private Seconds th1 = null;
  private Seconds th10 = null;
  private Seconds th11 = null;
  private Seconds th12 = null;
  private Seconds th2 = null;
  private Seconds th3 = null;
  private Seconds th4 = null;
  private Seconds th5 = null;
  private Seconds th6 = null;
  private Seconds th7 = null;
  private Seconds th8 = null;
  private Seconds th9 = null;
  private Seconds ti1 = null;
  private Seconds ti10 = null;
  private Seconds ti11 = null;
  private Seconds ti12 = null;
  private Seconds ti2 = null;
  private Seconds ti3 = null;
  private Seconds ti4 = null;
  private Seconds ti5 = null;
  private Seconds ti6 = null;
  private Seconds ti7 = null;
  private Seconds ti8 = null;
  private Seconds ti9 = null;
  private Seconds tl1 = null;
  private Seconds tl10 = null;
  private Seconds tl11 = null;
  private Seconds tl12 = null;
  private Seconds tl2 = null;
  private Seconds tl3 = null;
  private Seconds tl4 = null;
  private Seconds tl5 = null;
  private Seconds tl6 = null;
  private Seconds tl7 = null;
  private Seconds tl8 = null;
  private Seconds tl9 = null;
  private PU vhmax = null;
  private PU vhmin = null;
  private PU vimax = null;
  private PU vimin = null;
  private PU vlmax = null;
  private PU vlmin = null;
  private PU vstmax = null;
  private PU vstmin = null;

  private static final Logger LOGGER = Logger.getLogger(PssIEEE4BAggregate.class.getName());
}
