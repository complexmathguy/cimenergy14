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
 * Projector for PerCent as outlined for the CQRS pattern. All event handling and query handling
 * related to PerCent are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by PerCentAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("perCent")
@Component("perCent-projector")
public class PerCentProjector extends PerCentEntityProjector {

  // core constructor
  public PerCentProjector(PerCentRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePerCentEvent
   */
  @EventHandler(payloadType = CreatePerCentEvent.class)
  public void handle(CreatePerCentEvent event) {
    LOGGER.info("handling CreatePerCentEvent - " + event);
    PerCent entity = new PerCent();
    entity.setPerCentId(event.getPerCentId());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPerCent(entity);
  }

  /*
   * @param	event UpdatePerCentEvent
   */
  @EventHandler(payloadType = UpdatePerCentEvent.class)
  public void handle(UpdatePerCentEvent event) {
    LOGGER.info("handling UpdatePerCentEvent - " + event);

    PerCent entity = new PerCent();
    entity.setPerCentId(event.getPerCentId());
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
    emitFindPerCent(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPerCent(entity);
  }

  /*
   * @param	event DeletePerCentEvent
   */
  @EventHandler(payloadType = DeletePerCentEvent.class)
  public void handle(DeletePerCentEvent event) {
    LOGGER.info("handling DeletePerCentEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PerCent entity = delete(event.getPerCentId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPerCent(entity);
  }

  /*
   * @param	event AssignValueToPerCentEvent
   */
  @EventHandler(payloadType = AssignValueToPerCentEvent.class)
  public void handle(AssignValueToPerCentEvent event) {
    LOGGER.info("handling AssignValueToPerCentEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PerCent entity = assignValue(event.getPerCentId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPerCent(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPerCent(entity);
  }

  /*
   * @param	event UnAssignValueFromPerCentEvent
   */
  @EventHandler(payloadType = UnAssignValueFromPerCentEvent.class)
  public void handle(UnAssignValueFromPerCentEvent event) {
    LOGGER.info("handling UnAssignValueFromPerCentEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PerCent entity = unAssignValue(event.getPerCentId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPerCent(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPerCent(entity);
  }

  /**
   * Method to retrieve the PerCent via an PerCentPrimaryKey.
   *
   * @param id Long
   * @return PerCent
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PerCent handle(FindPerCentQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPerCentId());
  }

  /**
   * Method to retrieve a collection of all PerCents
   *
   * @param query FindAllPerCentQuery
   * @return List<PerCent>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PerCent> handle(FindAllPerCentQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPerCent, but only if the id matches
   *
   * @param entity PerCent
   */
  protected void emitFindPerCent(PerCent entity) {
    LOGGER.info("handling emitFindPerCent");

    queryUpdateEmitter.emit(
        FindPerCentQuery.class,
        query -> query.getFilter().getPerCentId().equals(entity.getPerCentId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPerCent
   *
   * @param entity PerCent
   */
  protected void emitFindAllPerCent(PerCent entity) {
    LOGGER.info("handling emitFindAllPerCent");

    queryUpdateEmitter.emit(FindAllPerCentQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PerCentProjector.class.getName());
}
