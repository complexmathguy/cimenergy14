package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.aggregate;

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
 * Aggregate handler for DCGround as outlined for the CQRS pattern, all write responsibilities
 * related to DCGround are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DCGroundAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DCGroundAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DCGroundAggregate(CreateDCGroundCommand command) throws Exception {
    LOGGER.info("Handling command CreateDCGroundCommand");
    CreateDCGroundEvent event = new CreateDCGroundEvent(command.getDCGroundId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDCGroundCommand command) throws Exception {
    LOGGER.info("handling command UpdateDCGroundCommand");
    UpdateDCGroundEvent event =
        new UpdateDCGroundEvent(command.getDCGroundId(), command.getInductance(), command.getR());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDCGroundCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDCGroundCommand");
    apply(new DeleteDCGroundEvent(command.getDCGroundId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignInductanceToDCGroundCommand command) throws Exception {
    LOGGER.info("Handling command AssignInductanceToDCGroundCommand");

    if (inductance != null
        && inductance.getInductanceId() == command.getAssignment().getInductanceId())
      throw new ProcessingException(
          "Inductance already assigned with id " + command.getAssignment().getInductanceId());

    apply(new AssignInductanceToDCGroundEvent(command.getDCGroundId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignInductanceFromDCGroundCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignInductanceFromDCGroundCommand");

    if (inductance == null)
      throw new ProcessingException("Inductance already has nothing assigned.");

    apply(new UnAssignInductanceFromDCGroundEvent(command.getDCGroundId()));
  }

  @CommandHandler
  public void handle(AssignRToDCGroundCommand command) throws Exception {
    LOGGER.info("Handling command AssignRToDCGroundCommand");

    if (r != null && r.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getResistanceId());

    apply(new AssignRToDCGroundEvent(command.getDCGroundId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromDCGroundCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromDCGroundCommand");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromDCGroundEvent(command.getDCGroundId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDCGroundEvent event) {
    LOGGER.info("Event sourcing CreateDCGroundEvent");
    this.dCGroundId = event.getDCGroundId();
  }

  @EventSourcingHandler
  void on(UpdateDCGroundEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.inductance = event.getInductance();
    this.r = event.getR();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignInductanceToDCGroundEvent event) {
    LOGGER.info("Event sourcing AssignInductanceToDCGroundEvent");
    this.inductance = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignInductanceFromDCGroundEvent event) {
    LOGGER.info("Event sourcing UnAssignInductanceFromDCGroundEvent");
    this.inductance = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToDCGroundEvent event) {
    LOGGER.info("Event sourcing AssignRToDCGroundEvent");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromDCGroundEvent event) {
    LOGGER.info("Event sourcing UnAssignRFromDCGroundEvent");
    this.r = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID dCGroundId;

  private Inductance inductance = null;
  private Resistance r = null;

  private static final Logger LOGGER = Logger.getLogger(DCGroundAggregate.class.getName());
}
