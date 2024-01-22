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
 * Projector for WindContCurrLimIEC as outlined for the CQRS pattern. All event handling and query
 * handling related to WindContCurrLimIEC are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by WindContCurrLimIECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windContCurrLimIEC")
@Component("windContCurrLimIEC-projector")
public class WindContCurrLimIECProjector extends WindContCurrLimIECEntityProjector {

  // core constructor
  public WindContCurrLimIECProjector(
      WindContCurrLimIECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindContCurrLimIECEvent
   */
  @EventHandler(payloadType = CreateWindContCurrLimIECEvent.class)
  public void handle(CreateWindContCurrLimIECEvent event) {
    LOGGER.info("handling CreateWindContCurrLimIECEvent - " + event);
    WindContCurrLimIEC entity = new WindContCurrLimIEC();
    entity.setWindContCurrLimIECId(event.getWindContCurrLimIECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContCurrLimIEC(entity);
  }

  /*
   * @param	event UpdateWindContCurrLimIECEvent
   */
  @EventHandler(payloadType = UpdateWindContCurrLimIECEvent.class)
  public void handle(UpdateWindContCurrLimIECEvent event) {
    LOGGER.info("handling UpdateWindContCurrLimIECEvent - " + event);

    WindContCurrLimIEC entity = new WindContCurrLimIEC();
    entity.setWindContCurrLimIECId(event.getWindContCurrLimIECId());
    entity.setImax(event.getImax());
    entity.setImaxdip(event.getImaxdip());
    entity.setMdfslim(event.getMdfslim());
    entity.setMqpri(event.getMqpri());
    entity.setTufilt(event.getTufilt());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContCurrLimIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContCurrLimIEC(entity);
  }

  /*
   * @param	event DeleteWindContCurrLimIECEvent
   */
  @EventHandler(payloadType = DeleteWindContCurrLimIECEvent.class)
  public void handle(DeleteWindContCurrLimIECEvent event) {
    LOGGER.info("handling DeleteWindContCurrLimIECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindContCurrLimIEC entity = delete(event.getWindContCurrLimIECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContCurrLimIEC(entity);
  }

  /*
   * @param	event AssignImaxToWindContCurrLimIECEvent
   */
  @EventHandler(payloadType = AssignImaxToWindContCurrLimIECEvent.class)
  public void handle(AssignImaxToWindContCurrLimIECEvent event) {
    LOGGER.info("handling AssignImaxToWindContCurrLimIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContCurrLimIEC entity = assignImax(event.getWindContCurrLimIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContCurrLimIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContCurrLimIEC(entity);
  }

  /*
   * @param	event UnAssignImaxFromWindContCurrLimIECEvent
   */
  @EventHandler(payloadType = UnAssignImaxFromWindContCurrLimIECEvent.class)
  public void handle(UnAssignImaxFromWindContCurrLimIECEvent event) {
    LOGGER.info("handling UnAssignImaxFromWindContCurrLimIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContCurrLimIEC entity = unAssignImax(event.getWindContCurrLimIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContCurrLimIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContCurrLimIEC(entity);
  }

  /*
   * @param	event AssignImaxdipToWindContCurrLimIECEvent
   */
  @EventHandler(payloadType = AssignImaxdipToWindContCurrLimIECEvent.class)
  public void handle(AssignImaxdipToWindContCurrLimIECEvent event) {
    LOGGER.info("handling AssignImaxdipToWindContCurrLimIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContCurrLimIEC entity =
        assignImaxdip(event.getWindContCurrLimIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContCurrLimIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContCurrLimIEC(entity);
  }

  /*
   * @param	event UnAssignImaxdipFromWindContCurrLimIECEvent
   */
  @EventHandler(payloadType = UnAssignImaxdipFromWindContCurrLimIECEvent.class)
  public void handle(UnAssignImaxdipFromWindContCurrLimIECEvent event) {
    LOGGER.info("handling UnAssignImaxdipFromWindContCurrLimIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContCurrLimIEC entity = unAssignImaxdip(event.getWindContCurrLimIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContCurrLimIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContCurrLimIEC(entity);
  }

  /*
   * @param	event AssignMdfslimToWindContCurrLimIECEvent
   */
  @EventHandler(payloadType = AssignMdfslimToWindContCurrLimIECEvent.class)
  public void handle(AssignMdfslimToWindContCurrLimIECEvent event) {
    LOGGER.info("handling AssignMdfslimToWindContCurrLimIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContCurrLimIEC entity =
        assignMdfslim(event.getWindContCurrLimIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContCurrLimIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContCurrLimIEC(entity);
  }

  /*
   * @param	event UnAssignMdfslimFromWindContCurrLimIECEvent
   */
  @EventHandler(payloadType = UnAssignMdfslimFromWindContCurrLimIECEvent.class)
  public void handle(UnAssignMdfslimFromWindContCurrLimIECEvent event) {
    LOGGER.info("handling UnAssignMdfslimFromWindContCurrLimIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContCurrLimIEC entity = unAssignMdfslim(event.getWindContCurrLimIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContCurrLimIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContCurrLimIEC(entity);
  }

  /*
   * @param	event AssignMqpriToWindContCurrLimIECEvent
   */
  @EventHandler(payloadType = AssignMqpriToWindContCurrLimIECEvent.class)
  public void handle(AssignMqpriToWindContCurrLimIECEvent event) {
    LOGGER.info("handling AssignMqpriToWindContCurrLimIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContCurrLimIEC entity = assignMqpri(event.getWindContCurrLimIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContCurrLimIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContCurrLimIEC(entity);
  }

  /*
   * @param	event UnAssignMqpriFromWindContCurrLimIECEvent
   */
  @EventHandler(payloadType = UnAssignMqpriFromWindContCurrLimIECEvent.class)
  public void handle(UnAssignMqpriFromWindContCurrLimIECEvent event) {
    LOGGER.info("handling UnAssignMqpriFromWindContCurrLimIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContCurrLimIEC entity = unAssignMqpri(event.getWindContCurrLimIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContCurrLimIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContCurrLimIEC(entity);
  }

  /*
   * @param	event AssignTufiltToWindContCurrLimIECEvent
   */
  @EventHandler(payloadType = AssignTufiltToWindContCurrLimIECEvent.class)
  public void handle(AssignTufiltToWindContCurrLimIECEvent event) {
    LOGGER.info("handling AssignTufiltToWindContCurrLimIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContCurrLimIEC entity =
        assignTufilt(event.getWindContCurrLimIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContCurrLimIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContCurrLimIEC(entity);
  }

  /*
   * @param	event UnAssignTufiltFromWindContCurrLimIECEvent
   */
  @EventHandler(payloadType = UnAssignTufiltFromWindContCurrLimIECEvent.class)
  public void handle(UnAssignTufiltFromWindContCurrLimIECEvent event) {
    LOGGER.info("handling UnAssignTufiltFromWindContCurrLimIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContCurrLimIEC entity = unAssignTufilt(event.getWindContCurrLimIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContCurrLimIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContCurrLimIEC(entity);
  }

  /**
   * Method to retrieve the WindContCurrLimIEC via an WindContCurrLimIECPrimaryKey.
   *
   * @param id Long
   * @return WindContCurrLimIEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindContCurrLimIEC handle(FindWindContCurrLimIECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindContCurrLimIECId());
  }

  /**
   * Method to retrieve a collection of all WindContCurrLimIECs
   *
   * @param query FindAllWindContCurrLimIECQuery
   * @return List<WindContCurrLimIEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindContCurrLimIEC> handle(FindAllWindContCurrLimIECQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindContCurrLimIEC, but only if the id matches
   *
   * @param entity WindContCurrLimIEC
   */
  protected void emitFindWindContCurrLimIEC(WindContCurrLimIEC entity) {
    LOGGER.info("handling emitFindWindContCurrLimIEC");

    queryUpdateEmitter.emit(
        FindWindContCurrLimIECQuery.class,
        query ->
            query.getFilter().getWindContCurrLimIECId().equals(entity.getWindContCurrLimIECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindContCurrLimIEC
   *
   * @param entity WindContCurrLimIEC
   */
  protected void emitFindAllWindContCurrLimIEC(WindContCurrLimIEC entity) {
    LOGGER.info("handling emitFindAllWindContCurrLimIEC");

    queryUpdateEmitter.emit(FindAllWindContCurrLimIECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(WindContCurrLimIECProjector.class.getName());
}
