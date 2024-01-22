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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for Pss1 as outlined for the CQRS pattern. All event handling and query handling
 * related to Pss1 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by Pss1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pss1")
@Component("pss1-projector")
public class Pss1Projector extends Pss1EntityProjector {

  // core constructor
  public Pss1Projector(Pss1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePss1Event
   */
  @EventHandler(payloadType = CreatePss1Event.class)
  public void handle(CreatePss1Event event) {
    LOGGER.info("handling CreatePss1Event - " + event);
    Pss1 entity = new Pss1();
    entity.setPss1Id(event.getPss1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UpdatePss1Event
   */
  @EventHandler(payloadType = UpdatePss1Event.class)
  public void handle(UpdatePss1Event event) {
    LOGGER.info("handling UpdatePss1Event - " + event);

    Pss1 entity = new Pss1();
    entity.setPss1Id(event.getPss1Id());
    entity.setKf(event.getKf());
    entity.setKpe(event.getKpe());
    entity.setKs(event.getKs());
    entity.setKw(event.getKw());
    entity.setPmin(event.getPmin());
    entity.setT10(event.getT10());
    entity.setT5(event.getT5());
    entity.setT6(event.getT6());
    entity.setT7(event.getT7());
    entity.setT8(event.getT8());
    entity.setT9(event.getT9());
    entity.setTpe(event.getTpe());
    entity.setVadat(event.getVadat());
    entity.setVsmn(event.getVsmn());
    entity.setVsmx(event.getVsmx());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event DeletePss1Event
   */
  @EventHandler(payloadType = DeletePss1Event.class)
  public void handle(DeletePss1Event event) {
    LOGGER.info("handling DeletePss1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    Pss1 entity = delete(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignKfToPss1Event
   */
  @EventHandler(payloadType = AssignKfToPss1Event.class)
  public void handle(AssignKfToPss1Event event) {
    LOGGER.info("handling AssignKfToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignKf(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignKfFromPss1Event
   */
  @EventHandler(payloadType = UnAssignKfFromPss1Event.class)
  public void handle(UnAssignKfFromPss1Event event) {
    LOGGER.info("handling UnAssignKfFromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignKf(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignKpeToPss1Event
   */
  @EventHandler(payloadType = AssignKpeToPss1Event.class)
  public void handle(AssignKpeToPss1Event event) {
    LOGGER.info("handling AssignKpeToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignKpe(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignKpeFromPss1Event
   */
  @EventHandler(payloadType = UnAssignKpeFromPss1Event.class)
  public void handle(UnAssignKpeFromPss1Event event) {
    LOGGER.info("handling UnAssignKpeFromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignKpe(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignKsToPss1Event
   */
  @EventHandler(payloadType = AssignKsToPss1Event.class)
  public void handle(AssignKsToPss1Event event) {
    LOGGER.info("handling AssignKsToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignKs(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignKsFromPss1Event
   */
  @EventHandler(payloadType = UnAssignKsFromPss1Event.class)
  public void handle(UnAssignKsFromPss1Event event) {
    LOGGER.info("handling UnAssignKsFromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignKs(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignKwToPss1Event
   */
  @EventHandler(payloadType = AssignKwToPss1Event.class)
  public void handle(AssignKwToPss1Event event) {
    LOGGER.info("handling AssignKwToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignKw(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignKwFromPss1Event
   */
  @EventHandler(payloadType = UnAssignKwFromPss1Event.class)
  public void handle(UnAssignKwFromPss1Event event) {
    LOGGER.info("handling UnAssignKwFromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignKw(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignPminToPss1Event
   */
  @EventHandler(payloadType = AssignPminToPss1Event.class)
  public void handle(AssignPminToPss1Event event) {
    LOGGER.info("handling AssignPminToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignPmin(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignPminFromPss1Event
   */
  @EventHandler(payloadType = UnAssignPminFromPss1Event.class)
  public void handle(UnAssignPminFromPss1Event event) {
    LOGGER.info("handling UnAssignPminFromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignPmin(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignT10ToPss1Event
   */
  @EventHandler(payloadType = AssignT10ToPss1Event.class)
  public void handle(AssignT10ToPss1Event event) {
    LOGGER.info("handling AssignT10ToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignT10(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignT10FromPss1Event
   */
  @EventHandler(payloadType = UnAssignT10FromPss1Event.class)
  public void handle(UnAssignT10FromPss1Event event) {
    LOGGER.info("handling UnAssignT10FromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignT10(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignT5ToPss1Event
   */
  @EventHandler(payloadType = AssignT5ToPss1Event.class)
  public void handle(AssignT5ToPss1Event event) {
    LOGGER.info("handling AssignT5ToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignT5(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignT5FromPss1Event
   */
  @EventHandler(payloadType = UnAssignT5FromPss1Event.class)
  public void handle(UnAssignT5FromPss1Event event) {
    LOGGER.info("handling UnAssignT5FromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignT5(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignT6ToPss1Event
   */
  @EventHandler(payloadType = AssignT6ToPss1Event.class)
  public void handle(AssignT6ToPss1Event event) {
    LOGGER.info("handling AssignT6ToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignT6(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignT6FromPss1Event
   */
  @EventHandler(payloadType = UnAssignT6FromPss1Event.class)
  public void handle(UnAssignT6FromPss1Event event) {
    LOGGER.info("handling UnAssignT6FromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignT6(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignT7ToPss1Event
   */
  @EventHandler(payloadType = AssignT7ToPss1Event.class)
  public void handle(AssignT7ToPss1Event event) {
    LOGGER.info("handling AssignT7ToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignT7(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignT7FromPss1Event
   */
  @EventHandler(payloadType = UnAssignT7FromPss1Event.class)
  public void handle(UnAssignT7FromPss1Event event) {
    LOGGER.info("handling UnAssignT7FromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignT7(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignT8ToPss1Event
   */
  @EventHandler(payloadType = AssignT8ToPss1Event.class)
  public void handle(AssignT8ToPss1Event event) {
    LOGGER.info("handling AssignT8ToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignT8(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignT8FromPss1Event
   */
  @EventHandler(payloadType = UnAssignT8FromPss1Event.class)
  public void handle(UnAssignT8FromPss1Event event) {
    LOGGER.info("handling UnAssignT8FromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignT8(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignT9ToPss1Event
   */
  @EventHandler(payloadType = AssignT9ToPss1Event.class)
  public void handle(AssignT9ToPss1Event event) {
    LOGGER.info("handling AssignT9ToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignT9(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignT9FromPss1Event
   */
  @EventHandler(payloadType = UnAssignT9FromPss1Event.class)
  public void handle(UnAssignT9FromPss1Event event) {
    LOGGER.info("handling UnAssignT9FromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignT9(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignTpeToPss1Event
   */
  @EventHandler(payloadType = AssignTpeToPss1Event.class)
  public void handle(AssignTpeToPss1Event event) {
    LOGGER.info("handling AssignTpeToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignTpe(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignTpeFromPss1Event
   */
  @EventHandler(payloadType = UnAssignTpeFromPss1Event.class)
  public void handle(UnAssignTpeFromPss1Event event) {
    LOGGER.info("handling UnAssignTpeFromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignTpe(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignVadatToPss1Event
   */
  @EventHandler(payloadType = AssignVadatToPss1Event.class)
  public void handle(AssignVadatToPss1Event event) {
    LOGGER.info("handling AssignVadatToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignVadat(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignVadatFromPss1Event
   */
  @EventHandler(payloadType = UnAssignVadatFromPss1Event.class)
  public void handle(UnAssignVadatFromPss1Event event) {
    LOGGER.info("handling UnAssignVadatFromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignVadat(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignVsmnToPss1Event
   */
  @EventHandler(payloadType = AssignVsmnToPss1Event.class)
  public void handle(AssignVsmnToPss1Event event) {
    LOGGER.info("handling AssignVsmnToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignVsmn(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignVsmnFromPss1Event
   */
  @EventHandler(payloadType = UnAssignVsmnFromPss1Event.class)
  public void handle(UnAssignVsmnFromPss1Event event) {
    LOGGER.info("handling UnAssignVsmnFromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignVsmn(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event AssignVsmxToPss1Event
   */
  @EventHandler(payloadType = AssignVsmxToPss1Event.class)
  public void handle(AssignVsmxToPss1Event event) {
    LOGGER.info("handling AssignVsmxToPss1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss1 entity = assignVsmx(event.getPss1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /*
   * @param	event UnAssignVsmxFromPss1Event
   */
  @EventHandler(payloadType = UnAssignVsmxFromPss1Event.class)
  public void handle(UnAssignVsmxFromPss1Event event) {
    LOGGER.info("handling UnAssignVsmxFromPss1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss1 entity = unAssignVsmx(event.getPss1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss1(entity);
  }

  /**
   * Method to retrieve the Pss1 via an Pss1PrimaryKey.
   *
   * @param id Long
   * @return Pss1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public Pss1 handle(FindPss1Query query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPss1Id());
  }

  /**
   * Method to retrieve a collection of all Pss1s
   *
   * @param query FindAllPss1Query
   * @return List<Pss1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<Pss1> handle(FindAllPss1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPss1, but only if the id matches
   *
   * @param entity Pss1
   */
  protected void emitFindPss1(Pss1 entity) {
    LOGGER.info("handling emitFindPss1");

    queryUpdateEmitter.emit(
        FindPss1Query.class,
        query -> query.getFilter().getPss1Id().equals(entity.getPss1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPss1
   *
   * @param entity Pss1
   */
  protected void emitFindAllPss1(Pss1 entity) {
    LOGGER.info("handling emitFindAllPss1");

    queryUpdateEmitter.emit(FindAllPss1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(Pss1Projector.class.getName());
}
