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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ACDCConverterDCTerminal as outlined for the CQRS pattern. All event handling and
 * query handling related to ACDCConverterDCTerminal are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by ACDCConverterDCTerminalAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("aCDCConverterDCTerminal")
@Component("aCDCConverterDCTerminal-projector")
public class ACDCConverterDCTerminalProjector extends ACDCConverterDCTerminalEntityProjector {

  // core constructor
  public ACDCConverterDCTerminalProjector(
      ACDCConverterDCTerminalRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateACDCConverterDCTerminalEvent
   */
  @EventHandler(payloadType = CreateACDCConverterDCTerminalEvent.class)
  public void handle(CreateACDCConverterDCTerminalEvent event) {
    LOGGER.info("handling CreateACDCConverterDCTerminalEvent - " + event);
    ACDCConverterDCTerminal entity = new ACDCConverterDCTerminal();
    entity.setACDCConverterDCTerminalId(event.getACDCConverterDCTerminalId());
    entity.setPolarity(event.getPolarity());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverterDCTerminal(entity);
  }

  /*
   * @param	event UpdateACDCConverterDCTerminalEvent
   */
  @EventHandler(payloadType = UpdateACDCConverterDCTerminalEvent.class)
  public void handle(UpdateACDCConverterDCTerminalEvent event) {
    LOGGER.info("handling UpdateACDCConverterDCTerminalEvent - " + event);

    ACDCConverterDCTerminal entity = new ACDCConverterDCTerminal();
    entity.setACDCConverterDCTerminalId(event.getACDCConverterDCTerminalId());
    entity.setPolarity(event.getPolarity());
    entity.setDCTerminals(event.getDCTerminals());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverterDCTerminal(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverterDCTerminal(entity);
  }

  /*
   * @param	event DeleteACDCConverterDCTerminalEvent
   */
  @EventHandler(payloadType = DeleteACDCConverterDCTerminalEvent.class)
  public void handle(DeleteACDCConverterDCTerminalEvent event) {
    LOGGER.info("handling DeleteACDCConverterDCTerminalEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ACDCConverterDCTerminal entity = delete(event.getACDCConverterDCTerminalId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverterDCTerminal(entity);
  }

  /*
   * @param	event AssignDCTerminalsToACDCConverterDCTerminalEvent
   */
  @EventHandler(payloadType = AssignDCTerminalsToACDCConverterDCTerminalEvent.class)
  public void handle(AssignDCTerminalsToACDCConverterDCTerminalEvent event) {
    LOGGER.info("handling AssignDCTerminalsToACDCConverterDCTerminalEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    ACDCConverterDCTerminal entity =
        addToDCTerminals(event.getACDCConverterDCTerminalId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverterDCTerminal(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverterDCTerminal(entity);
  }

  /*
   * @param	event RemoveDCTerminalsFromACDCConverterDCTerminalEvent
   */
  @EventHandler(payloadType = RemoveDCTerminalsFromACDCConverterDCTerminalEvent.class)
  public void handle(RemoveDCTerminalsFromACDCConverterDCTerminalEvent event) {
    LOGGER.info("handling RemoveDCTerminalsFromACDCConverterDCTerminalEvent - " + event);

    ACDCConverterDCTerminal entity =
        removeFromDCTerminals(event.getACDCConverterDCTerminalId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindACDCConverterDCTerminal(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllACDCConverterDCTerminal(entity);
  }

  /**
   * Method to retrieve the ACDCConverterDCTerminal via an ACDCConverterDCTerminalPrimaryKey.
   *
   * @param id Long
   * @return ACDCConverterDCTerminal
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ACDCConverterDCTerminal handle(FindACDCConverterDCTerminalQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getACDCConverterDCTerminalId());
  }

  /**
   * Method to retrieve a collection of all ACDCConverterDCTerminals
   *
   * @param query FindAllACDCConverterDCTerminalQuery
   * @return List<ACDCConverterDCTerminal>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ACDCConverterDCTerminal> handle(FindAllACDCConverterDCTerminalQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindACDCConverterDCTerminal, but only if the id matches
   *
   * @param entity ACDCConverterDCTerminal
   */
  protected void emitFindACDCConverterDCTerminal(ACDCConverterDCTerminal entity) {
    LOGGER.info("handling emitFindACDCConverterDCTerminal");

    queryUpdateEmitter.emit(
        FindACDCConverterDCTerminalQuery.class,
        query ->
            query
                .getFilter()
                .getACDCConverterDCTerminalId()
                .equals(entity.getACDCConverterDCTerminalId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllACDCConverterDCTerminal
   *
   * @param entity ACDCConverterDCTerminal
   */
  protected void emitFindAllACDCConverterDCTerminal(ACDCConverterDCTerminal entity) {
    LOGGER.info("handling emitFindAllACDCConverterDCTerminal");

    queryUpdateEmitter.emit(FindAllACDCConverterDCTerminalQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(ACDCConverterDCTerminalProjector.class.getName());
}
