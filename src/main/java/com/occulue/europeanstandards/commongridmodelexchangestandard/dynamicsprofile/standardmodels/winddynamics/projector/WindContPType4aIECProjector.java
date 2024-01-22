/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for WindContPType4aIEC as outlined for the CQRS pattern. All event handling and query
 * handling related to WindContPType4aIEC are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by WindContPType4aIECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windContPType4aIEC")
@Component("windContPType4aIEC-projector")
public class WindContPType4aIECProjector extends WindContPType4aIECEntityProjector {

  // core constructor
  public WindContPType4aIECProjector(
      WindContPType4aIECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindContPType4aIECEvent
   */
  @EventHandler(payloadType = CreateWindContPType4aIECEvent.class)
  public void handle(CreateWindContPType4aIECEvent event) {
    LOGGER.info("handling CreateWindContPType4aIECEvent - " + event);
    WindContPType4aIEC entity = new WindContPType4aIEC();
    entity.setWindContPType4aIECId(event.getWindContPType4aIECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType4aIEC(entity);
  }

  /*
   * @param	event UpdateWindContPType4aIECEvent
   */
  @EventHandler(payloadType = UpdateWindContPType4aIECEvent.class)
  public void handle(UpdateWindContPType4aIECEvent event) {
    LOGGER.info("handling UpdateWindContPType4aIECEvent - " + event);

    WindContPType4aIEC entity = new WindContPType4aIEC();
    entity.setWindContPType4aIECId(event.getWindContPType4aIECId());
    entity.setDpmax(event.getDpmax());
    entity.setTpord(event.getTpord());
    entity.setTufilt(event.getTufilt());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType4aIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType4aIEC(entity);
  }

  /*
   * @param	event DeleteWindContPType4aIECEvent
   */
  @EventHandler(payloadType = DeleteWindContPType4aIECEvent.class)
  public void handle(DeleteWindContPType4aIECEvent event) {
    LOGGER.info("handling DeleteWindContPType4aIECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindContPType4aIEC entity = delete(event.getWindContPType4aIECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType4aIEC(entity);
  }

  /*
   * @param	event AssignDpmaxToWindContPType4aIECEvent
   */
  @EventHandler(payloadType = AssignDpmaxToWindContPType4aIECEvent.class)
  public void handle(AssignDpmaxToWindContPType4aIECEvent event) {
    LOGGER.info("handling AssignDpmaxToWindContPType4aIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType4aIEC entity = assignDpmax(event.getWindContPType4aIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType4aIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType4aIEC(entity);
  }

  /*
   * @param	event UnAssignDpmaxFromWindContPType4aIECEvent
   */
  @EventHandler(payloadType = UnAssignDpmaxFromWindContPType4aIECEvent.class)
  public void handle(UnAssignDpmaxFromWindContPType4aIECEvent event) {
    LOGGER.info("handling UnAssignDpmaxFromWindContPType4aIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType4aIEC entity = unAssignDpmax(event.getWindContPType4aIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType4aIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType4aIEC(entity);
  }

  /*
   * @param	event AssignTpordToWindContPType4aIECEvent
   */
  @EventHandler(payloadType = AssignTpordToWindContPType4aIECEvent.class)
  public void handle(AssignTpordToWindContPType4aIECEvent event) {
    LOGGER.info("handling AssignTpordToWindContPType4aIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType4aIEC entity = assignTpord(event.getWindContPType4aIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType4aIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType4aIEC(entity);
  }

  /*
   * @param	event UnAssignTpordFromWindContPType4aIECEvent
   */
  @EventHandler(payloadType = UnAssignTpordFromWindContPType4aIECEvent.class)
  public void handle(UnAssignTpordFromWindContPType4aIECEvent event) {
    LOGGER.info("handling UnAssignTpordFromWindContPType4aIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType4aIEC entity = unAssignTpord(event.getWindContPType4aIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType4aIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType4aIEC(entity);
  }

  /*
   * @param	event AssignTufiltToWindContPType4aIECEvent
   */
  @EventHandler(payloadType = AssignTufiltToWindContPType4aIECEvent.class)
  public void handle(AssignTufiltToWindContPType4aIECEvent event) {
    LOGGER.info("handling AssignTufiltToWindContPType4aIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType4aIEC entity =
        assignTufilt(event.getWindContPType4aIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType4aIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType4aIEC(entity);
  }

  /*
   * @param	event UnAssignTufiltFromWindContPType4aIECEvent
   */
  @EventHandler(payloadType = UnAssignTufiltFromWindContPType4aIECEvent.class)
  public void handle(UnAssignTufiltFromWindContPType4aIECEvent event) {
    LOGGER.info("handling UnAssignTufiltFromWindContPType4aIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType4aIEC entity = unAssignTufilt(event.getWindContPType4aIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType4aIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType4aIEC(entity);
  }

  /**
   * Method to retrieve the WindContPType4aIEC via an WindContPType4aIECPrimaryKey.
   *
   * @param id Long
   * @return WindContPType4aIEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindContPType4aIEC handle(FindWindContPType4aIECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindContPType4aIECId());
  }

  /**
   * Method to retrieve a collection of all WindContPType4aIECs
   *
   * @param query FindAllWindContPType4aIECQuery
   * @return List<WindContPType4aIEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindContPType4aIEC> handle(FindAllWindContPType4aIECQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindContPType4aIEC, but only if the id matches
   *
   * @param entity WindContPType4aIEC
   */
  protected void emitFindWindContPType4aIEC(WindContPType4aIEC entity) {
    LOGGER.info("handling emitFindWindContPType4aIEC");

    queryUpdateEmitter.emit(
        FindWindContPType4aIECQuery.class,
        query ->
            query.getFilter().getWindContPType4aIECId().equals(entity.getWindContPType4aIECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindContPType4aIEC
   *
   * @param entity WindContPType4aIEC
   */
  protected void emitFindAllWindContPType4aIEC(WindContPType4aIEC entity) {
    LOGGER.info("handling emitFindAllWindContPType4aIEC");

    queryUpdateEmitter.emit(FindAllWindContPType4aIECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(WindContPType4aIECProjector.class.getName());
}
