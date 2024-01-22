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
 * Projector for Length as outlined for the CQRS pattern. All event handling and query handling
 * related to Length are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by LengthAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("length")
@Component("length-projector")
public class LengthProjector extends LengthEntityProjector {

  // core constructor
  public LengthProjector(LengthRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateLengthEvent
   */
  @EventHandler(payloadType = CreateLengthEvent.class)
  public void handle(CreateLengthEvent event) {
    LOGGER.info("handling CreateLengthEvent - " + event);
    Length entity = new Length();
    entity.setLengthId(event.getLengthId());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLength(entity);
  }

  /*
   * @param	event UpdateLengthEvent
   */
  @EventHandler(payloadType = UpdateLengthEvent.class)
  public void handle(UpdateLengthEvent event) {
    LOGGER.info("handling UpdateLengthEvent - " + event);

    Length entity = new Length();
    entity.setLengthId(event.getLengthId());
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
    emitFindLength(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLength(entity);
  }

  /*
   * @param	event DeleteLengthEvent
   */
  @EventHandler(payloadType = DeleteLengthEvent.class)
  public void handle(DeleteLengthEvent event) {
    LOGGER.info("handling DeleteLengthEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    Length entity = delete(event.getLengthId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLength(entity);
  }

  /*
   * @param	event AssignValueToLengthEvent
   */
  @EventHandler(payloadType = AssignValueToLengthEvent.class)
  public void handle(AssignValueToLengthEvent event) {
    LOGGER.info("handling AssignValueToLengthEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Length entity = assignValue(event.getLengthId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLength(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLength(entity);
  }

  /*
   * @param	event UnAssignValueFromLengthEvent
   */
  @EventHandler(payloadType = UnAssignValueFromLengthEvent.class)
  public void handle(UnAssignValueFromLengthEvent event) {
    LOGGER.info("handling UnAssignValueFromLengthEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Length entity = unAssignValue(event.getLengthId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLength(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLength(entity);
  }

  /**
   * Method to retrieve the Length via an LengthPrimaryKey.
   *
   * @param id Long
   * @return Length
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public Length handle(FindLengthQuery query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getLengthId());
  }

  /**
   * Method to retrieve a collection of all Lengths
   *
   * @param query FindAllLengthQuery
   * @return List<Length>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<Length> handle(FindAllLengthQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindLength, but only if the id matches
   *
   * @param entity Length
   */
  protected void emitFindLength(Length entity) {
    LOGGER.info("handling emitFindLength");

    queryUpdateEmitter.emit(
        FindLengthQuery.class,
        query -> query.getFilter().getLengthId().equals(entity.getLengthId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllLength
   *
   * @param entity Length
   */
  protected void emitFindAllLength(Length entity) {
    LOGGER.info("handling emitFindAllLength");

    queryUpdateEmitter.emit(FindAllLengthQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(LengthProjector.class.getName());
}
