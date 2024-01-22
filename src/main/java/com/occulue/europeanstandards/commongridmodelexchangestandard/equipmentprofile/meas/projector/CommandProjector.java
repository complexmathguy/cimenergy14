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
 * Projector for Command as outlined for the CQRS pattern. All event handling and query handling
 * related to Command are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by CommandAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("command")
@Component("command-projector")
public class CommandProjector extends CommandEntityProjector {

  // core constructor
  public CommandProjector(CommandRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateCommandEvent
   */
  @EventHandler(payloadType = CreateCommandEvent.class)
  public void handle(CreateCommandEvent event) {
    LOGGER.info("handling CreateCommandEvent - " + event);
    Command entity = new Command();
    entity.setCommandId(event.getCommandId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCommand(entity);
  }

  /*
   * @param	event UpdateCommandEvent
   */
  @EventHandler(payloadType = UpdateCommandEvent.class)
  public void handle(UpdateCommandEvent event) {
    LOGGER.info("handling UpdateCommandEvent - " + event);

    Command entity = new Command();
    entity.setCommandId(event.getCommandId());
    entity.setNormalValue(event.getNormalValue());
    entity.setValue(event.getValue());
    entity.setCommands(event.getCommands());
    entity.setCommand(event.getCommand());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCommand(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCommand(entity);
  }

  /*
   * @param	event DeleteCommandEvent
   */
  @EventHandler(payloadType = DeleteCommandEvent.class)
  public void handle(DeleteCommandEvent event) {
    LOGGER.info("handling DeleteCommandEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    Command entity = delete(event.getCommandId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCommand(entity);
  }

  /*
   * @param	event AssignNormalValueToCommandEvent
   */
  @EventHandler(payloadType = AssignNormalValueToCommandEvent.class)
  public void handle(AssignNormalValueToCommandEvent event) {
    LOGGER.info("handling AssignNormalValueToCommandEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Command entity = assignNormalValue(event.getCommandId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCommand(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCommand(entity);
  }

  /*
   * @param	event UnAssignNormalValueFromCommandEvent
   */
  @EventHandler(payloadType = UnAssignNormalValueFromCommandEvent.class)
  public void handle(UnAssignNormalValueFromCommandEvent event) {
    LOGGER.info("handling UnAssignNormalValueFromCommandEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Command entity = unAssignNormalValue(event.getCommandId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCommand(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCommand(entity);
  }

  /*
   * @param	event AssignValueToCommandEvent
   */
  @EventHandler(payloadType = AssignValueToCommandEvent.class)
  public void handle(AssignValueToCommandEvent event) {
    LOGGER.info("handling AssignValueToCommandEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Command entity = assignValue(event.getCommandId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCommand(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCommand(entity);
  }

  /*
   * @param	event UnAssignValueFromCommandEvent
   */
  @EventHandler(payloadType = UnAssignValueFromCommandEvent.class)
  public void handle(UnAssignValueFromCommandEvent event) {
    LOGGER.info("handling UnAssignValueFromCommandEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Command entity = unAssignValue(event.getCommandId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCommand(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCommand(entity);
  }

  /*
   * @param	event AssignCommandToCommandEvent
   */
  @EventHandler(payloadType = AssignCommandToCommandEvent.class)
  public void handle(AssignCommandToCommandEvent event) {
    LOGGER.info("handling AssignCommandToCommandEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Command entity = assignCommand(event.getCommandId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCommand(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCommand(entity);
  }

  /*
   * @param	event UnAssignCommandFromCommandEvent
   */
  @EventHandler(payloadType = UnAssignCommandFromCommandEvent.class)
  public void handle(UnAssignCommandFromCommandEvent event) {
    LOGGER.info("handling UnAssignCommandFromCommandEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Command entity = unAssignCommand(event.getCommandId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCommand(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCommand(entity);
  }

  /*
   * @param	event AssignCommandsToCommandEvent
   */
  @EventHandler(payloadType = AssignCommandsToCommandEvent.class)
  public void handle(AssignCommandsToCommandEvent event) {
    LOGGER.info("handling AssignCommandsToCommandEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    Command entity = addToCommands(event.getCommandId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCommand(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCommand(entity);
  }

  /*
   * @param	event RemoveCommandsFromCommandEvent
   */
  @EventHandler(payloadType = RemoveCommandsFromCommandEvent.class)
  public void handle(RemoveCommandsFromCommandEvent event) {
    LOGGER.info("handling RemoveCommandsFromCommandEvent - " + event);

    Command entity = removeFromCommands(event.getCommandId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCommand(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCommand(entity);
  }

  /**
   * Method to retrieve the Command via an CommandPrimaryKey.
   *
   * @param id Long
   * @return Command
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public Command handle(FindCommandQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getCommandId());
  }

  /**
   * Method to retrieve a collection of all Commands
   *
   * @param query FindAllCommandQuery
   * @return List<Command>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<Command> handle(FindAllCommandQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindCommand, but only if the id matches
   *
   * @param entity Command
   */
  protected void emitFindCommand(Command entity) {
    LOGGER.info("handling emitFindCommand");

    queryUpdateEmitter.emit(
        FindCommandQuery.class,
        query -> query.getFilter().getCommandId().equals(entity.getCommandId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllCommand
   *
   * @param entity Command
   */
  protected void emitFindAllCommand(Command entity) {
    LOGGER.info("handling emitFindAllCommand");

    queryUpdateEmitter.emit(FindAllCommandQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(CommandProjector.class.getName());
}
