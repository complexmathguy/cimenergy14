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
 * Aggregate handler for StringProxy as outlined for the CQRS pattern, all write responsibilities
 * related to StringProxy are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class StringProxyAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public StringProxyAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public StringProxyAggregate(CreateStringProxyCommand command) throws Exception {
    LOGGER.info("Handling command CreateStringProxyCommand");
    CreateStringProxyEvent event = new CreateStringProxyEvent(command.getStringProxyId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateStringProxyCommand command) throws Exception {
    LOGGER.info("handling command UpdateStringProxyCommand");
    UpdateStringProxyEvent event = new UpdateStringProxyEvent(command.getStringProxyId());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteStringProxyCommand command) throws Exception {
    LOGGER.info("Handling command DeleteStringProxyCommand");
    apply(new DeleteStringProxyEvent(command.getStringProxyId()));
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
  void on(CreateStringProxyEvent event) {
    LOGGER.info("Event sourcing CreateStringProxyEvent");
    this.stringProxyId = event.getStringProxyId();
  }

  @EventSourcingHandler
  void on(UpdateStringProxyEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID stringProxyId;

  private BoundaryExtensions fromEndIsoCode = null;
  private BoundaryExtensions fromEndName = null;
  private BoundaryExtensions fromEndNameTso = null;
  private BoundaryExtensions toEndIsoCode = null;
  private BoundaryExtensions toEndName = null;
  private BoundaryExtensions toEndNameTso = null;
  private ENTSOEIdentifiedObject energyIdentCodeEic = null;
  private ENTSOEIdentifiedObject shortName = null;
  private ExtensionVersion namespaceURI = null;
  private DomainVersion baseUML = null;
  private DomainVersion entsoeUML = null;
  private DomainVersion version = null;
  private EquipmentBoundaryVersion baseURI = null;
  private EquipmentBoundaryVersion differenceModelURI = null;
  private EquipmentBoundaryVersion entsoeURIcore = null;
  private EquipmentBoundaryVersion entsoeURIoperation = null;
  private EquipmentBoundaryVersion modelDescriptionURI = null;
  private EquipmentBoundaryVersion namespaceRDF = null;
  private EquipmentBoundaryVersion namespaceUML = null;
  private IdentifiedObject description = null;
  private IdentifiedObject mRID = null;
  private IdentifiedObject name = null;
  private TopologyBoundaryVersion entsoeURI = null;
  private EquipmentVersion baseURIcore = null;
  private EquipmentVersion baseURIoperation = null;
  private EquipmentVersion baseURIshortCircuit = null;
  private EquipmentVersion entsoeURIshortCircuit = null;
  private Control controlType = null;
  private Measurement measurementType = null;
  private StringMeasurementValue value = null;
  private CoordinateSystem crsUrn = null;
  private PositionPoint xPosition = null;
  private PositionPoint yPosition = null;
  private PositionPoint zPosition = null;
  private TextDiagramObject text = null;

  private static final Logger LOGGER = Logger.getLogger(StringProxyAggregate.class.getName());
}
