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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for AngleRadians as outlined for the CQRS pattern. All event handling and query
 * handling related to AngleRadians are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by AngleRadiansAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("angleRadians")
@Component("angleRadians-projector")
public class AngleRadiansProjector extends AngleRadiansEntityProjector {

  // core constructor
  public AngleRadiansProjector(
      AngleRadiansRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateAngleRadiansEvent
   */
  @EventHandler(payloadType = CreateAngleRadiansEvent.class)
  public void handle(CreateAngleRadiansEvent event) {
    LOGGER.info("handling CreateAngleRadiansEvent - " + event);
    AngleRadians entity = new AngleRadians();
    entity.setAngleRadiansId(event.getAngleRadiansId());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAngleRadians(entity);
  }

  /*
   * @param	event UpdateAngleRadiansEvent
   */
  @EventHandler(payloadType = UpdateAngleRadiansEvent.class)
  public void handle(UpdateAngleRadiansEvent event) {
    LOGGER.info("handling UpdateAngleRadiansEvent - " + event);

    AngleRadians entity = new AngleRadians();
    entity.setAngleRadiansId(event.getAngleRadiansId());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());
    entity.setValue(event.getValue());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAngleRadians(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAngleRadians(entity);
  }

  /*
   * @param	event DeleteAngleRadiansEvent
   */
  @EventHandler(payloadType = DeleteAngleRadiansEvent.class)
  public void handle(DeleteAngleRadiansEvent event) {
    LOGGER.info("handling DeleteAngleRadiansEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    AngleRadians entity = delete(event.getAngleRadiansId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAngleRadians(entity);
  }

  /*
   * @param	event AssignValueToAngleRadiansEvent
   */
  @EventHandler(payloadType = AssignValueToAngleRadiansEvent.class)
  public void handle(AssignValueToAngleRadiansEvent event) {
    LOGGER.info("handling AssignValueToAngleRadiansEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AngleRadians entity = assignValue(event.getAngleRadiansId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAngleRadians(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAngleRadians(entity);
  }

  /*
   * @param	event UnAssignValueFromAngleRadiansEvent
   */
  @EventHandler(payloadType = UnAssignValueFromAngleRadiansEvent.class)
  public void handle(UnAssignValueFromAngleRadiansEvent event) {
    LOGGER.info("handling UnAssignValueFromAngleRadiansEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AngleRadians entity = unAssignValue(event.getAngleRadiansId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAngleRadians(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAngleRadians(entity);
  }

  /**
   * Method to retrieve the AngleRadians via an AngleRadiansPrimaryKey.
   *
   * @param id Long
   * @return AngleRadians
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public AngleRadians handle(FindAngleRadiansQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getAngleRadiansId());
  }

  /**
   * Method to retrieve a collection of all AngleRadianss
   *
   * @param query FindAllAngleRadiansQuery
   * @return List<AngleRadians>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<AngleRadians> handle(FindAllAngleRadiansQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindAngleRadians, but only if the id matches
   *
   * @param entity AngleRadians
   */
  protected void emitFindAngleRadians(AngleRadians entity) {
    LOGGER.info("handling emitFindAngleRadians");

    queryUpdateEmitter.emit(
        FindAngleRadiansQuery.class,
        query -> query.getFilter().getAngleRadiansId().equals(entity.getAngleRadiansId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllAngleRadians
   *
   * @param entity AngleRadians
   */
  protected void emitFindAllAngleRadians(AngleRadians entity) {
    LOGGER.info("handling emitFindAllAngleRadians");

    queryUpdateEmitter.emit(FindAllAngleRadiansQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(AngleRadiansProjector.class.getName());
}
