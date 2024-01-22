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
 * Projector for WindDynamicsLookupTable as outlined for the CQRS pattern. All event handling and
 * query handling related to WindDynamicsLookupTable are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by WindDynamicsLookupTableAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windDynamicsLookupTable")
@Component("windDynamicsLookupTable-projector")
public class WindDynamicsLookupTableProjector extends WindDynamicsLookupTableEntityProjector {

  // core constructor
  public WindDynamicsLookupTableProjector(
      WindDynamicsLookupTableRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindDynamicsLookupTableEvent
   */
  @EventHandler(payloadType = CreateWindDynamicsLookupTableEvent.class)
  public void handle(CreateWindDynamicsLookupTableEvent event) {
    LOGGER.info("handling CreateWindDynamicsLookupTableEvent - " + event);
    WindDynamicsLookupTable entity = new WindDynamicsLookupTable();
    entity.setWindDynamicsLookupTableId(event.getWindDynamicsLookupTableId());
    entity.setLookupTableFunctionType(event.getLookupTableFunctionType());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindDynamicsLookupTable(entity);
  }

  /*
   * @param	event UpdateWindDynamicsLookupTableEvent
   */
  @EventHandler(payloadType = UpdateWindDynamicsLookupTableEvent.class)
  public void handle(UpdateWindDynamicsLookupTableEvent event) {
    LOGGER.info("handling UpdateWindDynamicsLookupTableEvent - " + event);

    WindDynamicsLookupTable entity = new WindDynamicsLookupTable();
    entity.setWindDynamicsLookupTableId(event.getWindDynamicsLookupTableId());
    entity.setInput(event.getInput());
    entity.setLookupTableFunctionType(event.getLookupTableFunctionType());
    entity.setOutput(event.getOutput());
    entity.setSequence(event.getSequence());
    entity.setWindDynamicsLookupTable(event.getWindDynamicsLookupTable());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindDynamicsLookupTable(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindDynamicsLookupTable(entity);
  }

  /*
   * @param	event DeleteWindDynamicsLookupTableEvent
   */
  @EventHandler(payloadType = DeleteWindDynamicsLookupTableEvent.class)
  public void handle(DeleteWindDynamicsLookupTableEvent event) {
    LOGGER.info("handling DeleteWindDynamicsLookupTableEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindDynamicsLookupTable entity = delete(event.getWindDynamicsLookupTableId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindDynamicsLookupTable(entity);
  }

  /*
   * @param	event AssignInputToWindDynamicsLookupTableEvent
   */
  @EventHandler(payloadType = AssignInputToWindDynamicsLookupTableEvent.class)
  public void handle(AssignInputToWindDynamicsLookupTableEvent event) {
    LOGGER.info("handling AssignInputToWindDynamicsLookupTableEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindDynamicsLookupTable entity =
        assignInput(event.getWindDynamicsLookupTableId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindDynamicsLookupTable(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindDynamicsLookupTable(entity);
  }

  /*
   * @param	event UnAssignInputFromWindDynamicsLookupTableEvent
   */
  @EventHandler(payloadType = UnAssignInputFromWindDynamicsLookupTableEvent.class)
  public void handle(UnAssignInputFromWindDynamicsLookupTableEvent event) {
    LOGGER.info("handling UnAssignInputFromWindDynamicsLookupTableEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindDynamicsLookupTable entity = unAssignInput(event.getWindDynamicsLookupTableId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindDynamicsLookupTable(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindDynamicsLookupTable(entity);
  }

  /*
   * @param	event AssignOutputToWindDynamicsLookupTableEvent
   */
  @EventHandler(payloadType = AssignOutputToWindDynamicsLookupTableEvent.class)
  public void handle(AssignOutputToWindDynamicsLookupTableEvent event) {
    LOGGER.info("handling AssignOutputToWindDynamicsLookupTableEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindDynamicsLookupTable entity =
        assignOutput(event.getWindDynamicsLookupTableId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindDynamicsLookupTable(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindDynamicsLookupTable(entity);
  }

  /*
   * @param	event UnAssignOutputFromWindDynamicsLookupTableEvent
   */
  @EventHandler(payloadType = UnAssignOutputFromWindDynamicsLookupTableEvent.class)
  public void handle(UnAssignOutputFromWindDynamicsLookupTableEvent event) {
    LOGGER.info("handling UnAssignOutputFromWindDynamicsLookupTableEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindDynamicsLookupTable entity = unAssignOutput(event.getWindDynamicsLookupTableId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindDynamicsLookupTable(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindDynamicsLookupTable(entity);
  }

  /*
   * @param	event AssignSequenceToWindDynamicsLookupTableEvent
   */
  @EventHandler(payloadType = AssignSequenceToWindDynamicsLookupTableEvent.class)
  public void handle(AssignSequenceToWindDynamicsLookupTableEvent event) {
    LOGGER.info("handling AssignSequenceToWindDynamicsLookupTableEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindDynamicsLookupTable entity =
        assignSequence(event.getWindDynamicsLookupTableId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindDynamicsLookupTable(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindDynamicsLookupTable(entity);
  }

  /*
   * @param	event UnAssignSequenceFromWindDynamicsLookupTableEvent
   */
  @EventHandler(payloadType = UnAssignSequenceFromWindDynamicsLookupTableEvent.class)
  public void handle(UnAssignSequenceFromWindDynamicsLookupTableEvent event) {
    LOGGER.info("handling UnAssignSequenceFromWindDynamicsLookupTableEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindDynamicsLookupTable entity = unAssignSequence(event.getWindDynamicsLookupTableId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindDynamicsLookupTable(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindDynamicsLookupTable(entity);
  }

  /*
   * @param	event AssignWindDynamicsLookupTableToWindDynamicsLookupTableEvent
   */
  @EventHandler(payloadType = AssignWindDynamicsLookupTableToWindDynamicsLookupTableEvent.class)
  public void handle(AssignWindDynamicsLookupTableToWindDynamicsLookupTableEvent event) {
    LOGGER.info("handling AssignWindDynamicsLookupTableToWindDynamicsLookupTableEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    WindDynamicsLookupTable entity =
        addToWindDynamicsLookupTable(event.getWindDynamicsLookupTableId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindDynamicsLookupTable(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindDynamicsLookupTable(entity);
  }

  /*
   * @param	event RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableEvent
   */
  @EventHandler(payloadType = RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableEvent.class)
  public void handle(RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableEvent event) {
    LOGGER.info(
        "handling RemoveWindDynamicsLookupTableFromWindDynamicsLookupTableEvent - " + event);

    WindDynamicsLookupTable entity =
        removeFromWindDynamicsLookupTable(
            event.getWindDynamicsLookupTableId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindDynamicsLookupTable(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindDynamicsLookupTable(entity);
  }

  /**
   * Method to retrieve the WindDynamicsLookupTable via an WindDynamicsLookupTablePrimaryKey.
   *
   * @param id Long
   * @return WindDynamicsLookupTable
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindDynamicsLookupTable handle(FindWindDynamicsLookupTableQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindDynamicsLookupTableId());
  }

  /**
   * Method to retrieve a collection of all WindDynamicsLookupTables
   *
   * @param query FindAllWindDynamicsLookupTableQuery
   * @return List<WindDynamicsLookupTable>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindDynamicsLookupTable> handle(FindAllWindDynamicsLookupTableQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindDynamicsLookupTable, but only if the id matches
   *
   * @param entity WindDynamicsLookupTable
   */
  protected void emitFindWindDynamicsLookupTable(WindDynamicsLookupTable entity) {
    LOGGER.info("handling emitFindWindDynamicsLookupTable");

    queryUpdateEmitter.emit(
        FindWindDynamicsLookupTableQuery.class,
        query ->
            query
                .getFilter()
                .getWindDynamicsLookupTableId()
                .equals(entity.getWindDynamicsLookupTableId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindDynamicsLookupTable
   *
   * @param entity WindDynamicsLookupTable
   */
  protected void emitFindAllWindDynamicsLookupTable(WindDynamicsLookupTable entity) {
    LOGGER.info("handling emitFindAllWindDynamicsLookupTable");

    queryUpdateEmitter.emit(FindAllWindDynamicsLookupTableQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(WindDynamicsLookupTableProjector.class.getName());
}
