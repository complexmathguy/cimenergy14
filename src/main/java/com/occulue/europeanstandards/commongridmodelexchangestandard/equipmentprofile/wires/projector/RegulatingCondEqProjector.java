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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for RegulatingCondEq as outlined for the CQRS pattern. All event handling and query
 * handling related to RegulatingCondEq are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by RegulatingCondEqAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("regulatingCondEq")
@Component("regulatingCondEq-projector")
public class RegulatingCondEqProjector extends RegulatingCondEqEntityProjector {

  // core constructor
  public RegulatingCondEqProjector(
      RegulatingCondEqRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateRegulatingCondEqEvent
   */
  @EventHandler(payloadType = CreateRegulatingCondEqEvent.class)
  public void handle(CreateRegulatingCondEqEvent event) {
    LOGGER.info("handling CreateRegulatingCondEqEvent - " + event);
    RegulatingCondEq entity = new RegulatingCondEq();
    entity.setRegulatingCondEqId(event.getRegulatingCondEqId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegulatingCondEq(entity);
  }

  /*
   * @param	event UpdateRegulatingCondEqEvent
   */
  @EventHandler(payloadType = UpdateRegulatingCondEqEvent.class)
  public void handle(UpdateRegulatingCondEqEvent event) {
    LOGGER.info("handling UpdateRegulatingCondEqEvent - " + event);

    RegulatingCondEq entity = new RegulatingCondEq();
    entity.setRegulatingCondEqId(event.getRegulatingCondEqId());
    entity.setRegulatingCondEq(event.getRegulatingCondEq());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRegulatingCondEq(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegulatingCondEq(entity);
  }

  /*
   * @param	event DeleteRegulatingCondEqEvent
   */
  @EventHandler(payloadType = DeleteRegulatingCondEqEvent.class)
  public void handle(DeleteRegulatingCondEqEvent event) {
    LOGGER.info("handling DeleteRegulatingCondEqEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    RegulatingCondEq entity = delete(event.getRegulatingCondEqId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegulatingCondEq(entity);
  }

  /*
   * @param	event AssignRegulatingCondEqToRegulatingCondEqEvent
   */
  @EventHandler(payloadType = AssignRegulatingCondEqToRegulatingCondEqEvent.class)
  public void handle(AssignRegulatingCondEqToRegulatingCondEqEvent event) {
    LOGGER.info("handling AssignRegulatingCondEqToRegulatingCondEqEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    RegulatingCondEq entity =
        addToRegulatingCondEq(event.getRegulatingCondEqId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRegulatingCondEq(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegulatingCondEq(entity);
  }

  /*
   * @param	event RemoveRegulatingCondEqFromRegulatingCondEqEvent
   */
  @EventHandler(payloadType = RemoveRegulatingCondEqFromRegulatingCondEqEvent.class)
  public void handle(RemoveRegulatingCondEqFromRegulatingCondEqEvent event) {
    LOGGER.info("handling RemoveRegulatingCondEqFromRegulatingCondEqEvent - " + event);

    RegulatingCondEq entity =
        removeFromRegulatingCondEq(event.getRegulatingCondEqId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRegulatingCondEq(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegulatingCondEq(entity);
  }

  /**
   * Method to retrieve the RegulatingCondEq via an RegulatingCondEqPrimaryKey.
   *
   * @param id Long
   * @return RegulatingCondEq
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public RegulatingCondEq handle(FindRegulatingCondEqQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getRegulatingCondEqId());
  }

  /**
   * Method to retrieve a collection of all RegulatingCondEqs
   *
   * @param query FindAllRegulatingCondEqQuery
   * @return List<RegulatingCondEq>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<RegulatingCondEq> handle(FindAllRegulatingCondEqQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindRegulatingCondEq, but only if the id matches
   *
   * @param entity RegulatingCondEq
   */
  protected void emitFindRegulatingCondEq(RegulatingCondEq entity) {
    LOGGER.info("handling emitFindRegulatingCondEq");

    queryUpdateEmitter.emit(
        FindRegulatingCondEqQuery.class,
        query -> query.getFilter().getRegulatingCondEqId().equals(entity.getRegulatingCondEqId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllRegulatingCondEq
   *
   * @param entity RegulatingCondEq
   */
  protected void emitFindAllRegulatingCondEq(RegulatingCondEq entity) {
    LOGGER.info("handling emitFindAllRegulatingCondEq");

    queryUpdateEmitter.emit(FindAllRegulatingCondEqQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(RegulatingCondEqProjector.class.getName());
}
