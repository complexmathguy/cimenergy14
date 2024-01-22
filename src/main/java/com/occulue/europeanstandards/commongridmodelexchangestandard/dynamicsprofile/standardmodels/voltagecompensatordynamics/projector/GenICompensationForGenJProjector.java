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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for GenICompensationForGenJ as outlined for the CQRS pattern. All event handling and
 * query handling related to GenICompensationForGenJ are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by GenICompensationForGenJAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("genICompensationForGenJ")
@Component("genICompensationForGenJ-projector")
public class GenICompensationForGenJProjector extends GenICompensationForGenJEntityProjector {

  // core constructor
  public GenICompensationForGenJProjector(
      GenICompensationForGenJRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGenICompensationForGenJEvent
   */
  @EventHandler(payloadType = CreateGenICompensationForGenJEvent.class)
  public void handle(CreateGenICompensationForGenJEvent event) {
    LOGGER.info("handling CreateGenICompensationForGenJEvent - " + event);
    GenICompensationForGenJ entity = new GenICompensationForGenJ();
    entity.setGenICompensationForGenJId(event.getGenICompensationForGenJId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGenICompensationForGenJ(entity);
  }

  /*
   * @param	event UpdateGenICompensationForGenJEvent
   */
  @EventHandler(payloadType = UpdateGenICompensationForGenJEvent.class)
  public void handle(UpdateGenICompensationForGenJEvent event) {
    LOGGER.info("handling UpdateGenICompensationForGenJEvent - " + event);

    GenICompensationForGenJ entity = new GenICompensationForGenJ();
    entity.setGenICompensationForGenJId(event.getGenICompensationForGenJId());
    entity.setRcij(event.getRcij());
    entity.setXcij(event.getXcij());
    entity.setGenICompensationForGenJ(event.getGenICompensationForGenJ());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGenICompensationForGenJ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGenICompensationForGenJ(entity);
  }

  /*
   * @param	event DeleteGenICompensationForGenJEvent
   */
  @EventHandler(payloadType = DeleteGenICompensationForGenJEvent.class)
  public void handle(DeleteGenICompensationForGenJEvent event) {
    LOGGER.info("handling DeleteGenICompensationForGenJEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GenICompensationForGenJ entity = delete(event.getGenICompensationForGenJId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGenICompensationForGenJ(entity);
  }

  /*
   * @param	event AssignRcijToGenICompensationForGenJEvent
   */
  @EventHandler(payloadType = AssignRcijToGenICompensationForGenJEvent.class)
  public void handle(AssignRcijToGenICompensationForGenJEvent event) {
    LOGGER.info("handling AssignRcijToGenICompensationForGenJEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GenICompensationForGenJ entity =
        assignRcij(event.getGenICompensationForGenJId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGenICompensationForGenJ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGenICompensationForGenJ(entity);
  }

  /*
   * @param	event UnAssignRcijFromGenICompensationForGenJEvent
   */
  @EventHandler(payloadType = UnAssignRcijFromGenICompensationForGenJEvent.class)
  public void handle(UnAssignRcijFromGenICompensationForGenJEvent event) {
    LOGGER.info("handling UnAssignRcijFromGenICompensationForGenJEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GenICompensationForGenJ entity = unAssignRcij(event.getGenICompensationForGenJId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGenICompensationForGenJ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGenICompensationForGenJ(entity);
  }

  /*
   * @param	event AssignXcijToGenICompensationForGenJEvent
   */
  @EventHandler(payloadType = AssignXcijToGenICompensationForGenJEvent.class)
  public void handle(AssignXcijToGenICompensationForGenJEvent event) {
    LOGGER.info("handling AssignXcijToGenICompensationForGenJEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GenICompensationForGenJ entity =
        assignXcij(event.getGenICompensationForGenJId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGenICompensationForGenJ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGenICompensationForGenJ(entity);
  }

  /*
   * @param	event UnAssignXcijFromGenICompensationForGenJEvent
   */
  @EventHandler(payloadType = UnAssignXcijFromGenICompensationForGenJEvent.class)
  public void handle(UnAssignXcijFromGenICompensationForGenJEvent event) {
    LOGGER.info("handling UnAssignXcijFromGenICompensationForGenJEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GenICompensationForGenJ entity = unAssignXcij(event.getGenICompensationForGenJId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGenICompensationForGenJ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGenICompensationForGenJ(entity);
  }

  /*
   * @param	event AssignGenICompensationForGenJToGenICompensationForGenJEvent
   */
  @EventHandler(payloadType = AssignGenICompensationForGenJToGenICompensationForGenJEvent.class)
  public void handle(AssignGenICompensationForGenJToGenICompensationForGenJEvent event) {
    LOGGER.info("handling AssignGenICompensationForGenJToGenICompensationForGenJEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    GenICompensationForGenJ entity =
        addToGenICompensationForGenJ(event.getGenICompensationForGenJId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGenICompensationForGenJ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGenICompensationForGenJ(entity);
  }

  /*
   * @param	event RemoveGenICompensationForGenJFromGenICompensationForGenJEvent
   */
  @EventHandler(payloadType = RemoveGenICompensationForGenJFromGenICompensationForGenJEvent.class)
  public void handle(RemoveGenICompensationForGenJFromGenICompensationForGenJEvent event) {
    LOGGER.info(
        "handling RemoveGenICompensationForGenJFromGenICompensationForGenJEvent - " + event);

    GenICompensationForGenJ entity =
        removeFromGenICompensationForGenJ(
            event.getGenICompensationForGenJId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGenICompensationForGenJ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGenICompensationForGenJ(entity);
  }

  /**
   * Method to retrieve the GenICompensationForGenJ via an GenICompensationForGenJPrimaryKey.
   *
   * @param id Long
   * @return GenICompensationForGenJ
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GenICompensationForGenJ handle(FindGenICompensationForGenJQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGenICompensationForGenJId());
  }

  /**
   * Method to retrieve a collection of all GenICompensationForGenJs
   *
   * @param query FindAllGenICompensationForGenJQuery
   * @return List<GenICompensationForGenJ>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GenICompensationForGenJ> handle(FindAllGenICompensationForGenJQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGenICompensationForGenJ, but only if the id matches
   *
   * @param entity GenICompensationForGenJ
   */
  protected void emitFindGenICompensationForGenJ(GenICompensationForGenJ entity) {
    LOGGER.info("handling emitFindGenICompensationForGenJ");

    queryUpdateEmitter.emit(
        FindGenICompensationForGenJQuery.class,
        query ->
            query
                .getFilter()
                .getGenICompensationForGenJId()
                .equals(entity.getGenICompensationForGenJId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGenICompensationForGenJ
   *
   * @param entity GenICompensationForGenJ
   */
  protected void emitFindAllGenICompensationForGenJ(GenICompensationForGenJ entity) {
    LOGGER.info("handling emitFindAllGenICompensationForGenJ");

    queryUpdateEmitter.emit(FindAllGenICompensationForGenJQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(GenICompensationForGenJProjector.class.getName());
}
