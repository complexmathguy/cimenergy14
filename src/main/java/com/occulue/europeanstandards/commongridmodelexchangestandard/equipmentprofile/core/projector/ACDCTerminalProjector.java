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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ACDCTerminal as outlined for the CQRS pattern. All event handling and query
 * handling related to ACDCTerminal are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by ACDCTerminalAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("aCDCTerminal")
@Component("aCDCTerminal-projector")
public class ACDCTerminalProjector extends ACDCTerminalEntityProjector {

  // core constructor
  public ACDCTerminalProjector(
      ACDCTerminalRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateACDCTerminalEvent
   */
  @EventHandler(payloadType = CreateACDCTerminalEvent.class)
  public void handle(CreateACDCTerminalEvent event) {
    LOGGER.info("handling CreateACDCTerminalEvent - " + event);
    ACDCTerminal entity = new ACDCTerminal();
    entity.setACDCTerminalId(event.getACDCTerminalId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCTerminal(entity);
  }

  /*
   * @param	event UpdateACDCTerminalEvent
   */
  @EventHandler(payloadType = UpdateACDCTerminalEvent.class)
  public void handle(UpdateACDCTerminalEvent event) {
    LOGGER.info("handling UpdateACDCTerminalEvent - " + event);

    ACDCTerminal entity = new ACDCTerminal();
    entity.setACDCTerminalId(event.getACDCTerminalId());
    entity.setSequenceNumber(event.getSequenceNumber());
    entity.setTerminal(event.getTerminal());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCTerminal(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCTerminal(entity);
  }

  /*
   * @param	event DeleteACDCTerminalEvent
   */
  @EventHandler(payloadType = DeleteACDCTerminalEvent.class)
  public void handle(DeleteACDCTerminalEvent event) {
    LOGGER.info("handling DeleteACDCTerminalEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ACDCTerminal entity = delete(event.getACDCTerminalId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCTerminal(entity);
  }

  /*
   * @param	event AssignSequenceNumberToACDCTerminalEvent
   */
  @EventHandler(payloadType = AssignSequenceNumberToACDCTerminalEvent.class)
  public void handle(AssignSequenceNumberToACDCTerminalEvent event) {
    LOGGER.info("handling AssignSequenceNumberToACDCTerminalEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ACDCTerminal entity = assignSequenceNumber(event.getACDCTerminalId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCTerminal(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCTerminal(entity);
  }

  /*
   * @param	event UnAssignSequenceNumberFromACDCTerminalEvent
   */
  @EventHandler(payloadType = UnAssignSequenceNumberFromACDCTerminalEvent.class)
  public void handle(UnAssignSequenceNumberFromACDCTerminalEvent event) {
    LOGGER.info("handling UnAssignSequenceNumberFromACDCTerminalEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ACDCTerminal entity = unAssignSequenceNumber(event.getACDCTerminalId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCTerminal(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCTerminal(entity);
  }

  /*
   * @param	event AssignTerminalToACDCTerminalEvent
   */
  @EventHandler(payloadType = AssignTerminalToACDCTerminalEvent.class)
  public void handle(AssignTerminalToACDCTerminalEvent event) {
    LOGGER.info("handling AssignTerminalToACDCTerminalEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    ACDCTerminal entity = addToTerminal(event.getACDCTerminalId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCTerminal(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCTerminal(entity);
  }

  /*
   * @param	event RemoveTerminalFromACDCTerminalEvent
   */
  @EventHandler(payloadType = RemoveTerminalFromACDCTerminalEvent.class)
  public void handle(RemoveTerminalFromACDCTerminalEvent event) {
    LOGGER.info("handling RemoveTerminalFromACDCTerminalEvent - " + event);

    ACDCTerminal entity = removeFromTerminal(event.getACDCTerminalId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCTerminal(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCTerminal(entity);
  }

  /**
   * Method to retrieve the ACDCTerminal via an ACDCTerminalPrimaryKey.
   *
   * @param id Long
   * @return ACDCTerminal
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ACDCTerminal handle(FindACDCTerminalQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getACDCTerminalId());
  }

  /**
   * Method to retrieve a collection of all ACDCTerminals
   *
   * @param query FindAllACDCTerminalQuery
   * @return List<ACDCTerminal>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ACDCTerminal> handle(FindAllACDCTerminalQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindACDCTerminal, but only if the id matches
   *
   * @param entity ACDCTerminal
   */
  protected void emitFindACDCTerminal(ACDCTerminal entity) {
    LOGGER.info("handling emitFindACDCTerminal");

    queryUpdateEmitter.emit(
        FindACDCTerminalQuery.class,
        query -> query.getFilter().getACDCTerminalId().equals(entity.getACDCTerminalId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllACDCTerminal
   *
   * @param entity ACDCTerminal
   */
  protected void emitFindAllACDCTerminal(ACDCTerminal entity) {
    LOGGER.info("handling emitFindAllACDCTerminal");

    queryUpdateEmitter.emit(FindAllACDCTerminalQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ACDCTerminalProjector.class.getName());
}
