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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for RaiseLowerCommand as outlined for the CQRS pattern. All event handling and query
 * handling related to RaiseLowerCommand are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by RaiseLowerCommandAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("raiseLowerCommand")
@Component("raiseLowerCommand-projector")
public class RaiseLowerCommandProjector extends RaiseLowerCommandEntityProjector {

  // core constructor
  public RaiseLowerCommandProjector(
      RaiseLowerCommandRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateRaiseLowerCommandEvent
   */
  @EventHandler(payloadType = CreateRaiseLowerCommandEvent.class)
  public void handle(CreateRaiseLowerCommandEvent event) {
    LOGGER.info("handling CreateRaiseLowerCommandEvent - " + event);
    RaiseLowerCommand entity = new RaiseLowerCommand();
    entity.setRaiseLowerCommandId(event.getRaiseLowerCommandId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRaiseLowerCommand(entity);
  }

  /*
   * @param	event UpdateRaiseLowerCommandEvent
   */
  @EventHandler(payloadType = UpdateRaiseLowerCommandEvent.class)
  public void handle(UpdateRaiseLowerCommandEvent event) {
    LOGGER.info("handling UpdateRaiseLowerCommandEvent - " + event);

    RaiseLowerCommand entity = new RaiseLowerCommand();
    entity.setRaiseLowerCommandId(event.getRaiseLowerCommandId());
    entity.setRaiseLowerCommands(event.getRaiseLowerCommands());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRaiseLowerCommand(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRaiseLowerCommand(entity);
  }

  /*
   * @param	event DeleteRaiseLowerCommandEvent
   */
  @EventHandler(payloadType = DeleteRaiseLowerCommandEvent.class)
  public void handle(DeleteRaiseLowerCommandEvent event) {
    LOGGER.info("handling DeleteRaiseLowerCommandEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    RaiseLowerCommand entity = delete(event.getRaiseLowerCommandId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRaiseLowerCommand(entity);
  }

  /*
   * @param	event AssignRaiseLowerCommandsToRaiseLowerCommandEvent
   */
  @EventHandler(payloadType = AssignRaiseLowerCommandsToRaiseLowerCommandEvent.class)
  public void handle(AssignRaiseLowerCommandsToRaiseLowerCommandEvent event) {
    LOGGER.info("handling AssignRaiseLowerCommandsToRaiseLowerCommandEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    RaiseLowerCommand entity =
        addToRaiseLowerCommands(event.getRaiseLowerCommandId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRaiseLowerCommand(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRaiseLowerCommand(entity);
  }

  /*
   * @param	event RemoveRaiseLowerCommandsFromRaiseLowerCommandEvent
   */
  @EventHandler(payloadType = RemoveRaiseLowerCommandsFromRaiseLowerCommandEvent.class)
  public void handle(RemoveRaiseLowerCommandsFromRaiseLowerCommandEvent event) {
    LOGGER.info("handling RemoveRaiseLowerCommandsFromRaiseLowerCommandEvent - " + event);

    RaiseLowerCommand entity =
        removeFromRaiseLowerCommands(event.getRaiseLowerCommandId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRaiseLowerCommand(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRaiseLowerCommand(entity);
  }

  /**
   * Method to retrieve the RaiseLowerCommand via an RaiseLowerCommandPrimaryKey.
   *
   * @param id Long
   * @return RaiseLowerCommand
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public RaiseLowerCommand handle(FindRaiseLowerCommandQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getRaiseLowerCommandId());
  }

  /**
   * Method to retrieve a collection of all RaiseLowerCommands
   *
   * @param query FindAllRaiseLowerCommandQuery
   * @return List<RaiseLowerCommand>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<RaiseLowerCommand> handle(FindAllRaiseLowerCommandQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindRaiseLowerCommand, but only if the id matches
   *
   * @param entity RaiseLowerCommand
   */
  protected void emitFindRaiseLowerCommand(RaiseLowerCommand entity) {
    LOGGER.info("handling emitFindRaiseLowerCommand");

    queryUpdateEmitter.emit(
        FindRaiseLowerCommandQuery.class,
        query -> query.getFilter().getRaiseLowerCommandId().equals(entity.getRaiseLowerCommandId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllRaiseLowerCommand
   *
   * @param entity RaiseLowerCommand
   */
  protected void emitFindAllRaiseLowerCommand(RaiseLowerCommand entity) {
    LOGGER.info("handling emitFindAllRaiseLowerCommand");

    queryUpdateEmitter.emit(FindAllRaiseLowerCommandQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(RaiseLowerCommandProjector.class.getName());
}
