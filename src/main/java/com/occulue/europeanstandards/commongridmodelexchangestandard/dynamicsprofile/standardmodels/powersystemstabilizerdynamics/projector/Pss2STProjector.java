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
 * Projector for Pss2ST as outlined for the CQRS pattern. All event handling and query handling
 * related to Pss2ST are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by Pss2STAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pss2ST")
@Component("pss2ST-projector")
public class Pss2STProjector extends Pss2STEntityProjector {

  // core constructor
  public Pss2STProjector(Pss2STRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePss2STEvent
   */
  @EventHandler(payloadType = CreatePss2STEvent.class)
  public void handle(CreatePss2STEvent event) {
    LOGGER.info("handling CreatePss2STEvent - " + event);
    Pss2ST entity = new Pss2ST();
    entity.setPss2STId(event.getPss2STId());
    entity.setInputSignal1Type(event.getInputSignal1Type());
    entity.setInputSignal2Type(event.getInputSignal2Type());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UpdatePss2STEvent
   */
  @EventHandler(payloadType = UpdatePss2STEvent.class)
  public void handle(UpdatePss2STEvent event) {
    LOGGER.info("handling UpdatePss2STEvent - " + event);

    Pss2ST entity = new Pss2ST();
    entity.setPss2STId(event.getPss2STId());
    entity.setInputSignal1Type(event.getInputSignal1Type());
    entity.setInputSignal2Type(event.getInputSignal2Type());
    entity.setK1(event.getK1());
    entity.setK2(event.getK2());
    entity.setLsmax(event.getLsmax());
    entity.setLsmin(event.getLsmin());
    entity.setT1(event.getT1());
    entity.setT10(event.getT10());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setT6(event.getT6());
    entity.setT7(event.getT7());
    entity.setT8(event.getT8());
    entity.setT9(event.getT9());
    entity.setVcl(event.getVcl());
    entity.setVcu(event.getVcu());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event DeletePss2STEvent
   */
  @EventHandler(payloadType = DeletePss2STEvent.class)
  public void handle(DeletePss2STEvent event) {
    LOGGER.info("handling DeletePss2STEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    Pss2ST entity = delete(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignK1ToPss2STEvent
   */
  @EventHandler(payloadType = AssignK1ToPss2STEvent.class)
  public void handle(AssignK1ToPss2STEvent event) {
    LOGGER.info("handling AssignK1ToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignK1(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignK1FromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignK1FromPss2STEvent.class)
  public void handle(UnAssignK1FromPss2STEvent event) {
    LOGGER.info("handling UnAssignK1FromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignK1(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignK2ToPss2STEvent
   */
  @EventHandler(payloadType = AssignK2ToPss2STEvent.class)
  public void handle(AssignK2ToPss2STEvent event) {
    LOGGER.info("handling AssignK2ToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignK2(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignK2FromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignK2FromPss2STEvent.class)
  public void handle(UnAssignK2FromPss2STEvent event) {
    LOGGER.info("handling UnAssignK2FromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignK2(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignLsmaxToPss2STEvent
   */
  @EventHandler(payloadType = AssignLsmaxToPss2STEvent.class)
  public void handle(AssignLsmaxToPss2STEvent event) {
    LOGGER.info("handling AssignLsmaxToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignLsmax(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignLsmaxFromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignLsmaxFromPss2STEvent.class)
  public void handle(UnAssignLsmaxFromPss2STEvent event) {
    LOGGER.info("handling UnAssignLsmaxFromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignLsmax(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignLsminToPss2STEvent
   */
  @EventHandler(payloadType = AssignLsminToPss2STEvent.class)
  public void handle(AssignLsminToPss2STEvent event) {
    LOGGER.info("handling AssignLsminToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignLsmin(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignLsminFromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignLsminFromPss2STEvent.class)
  public void handle(UnAssignLsminFromPss2STEvent event) {
    LOGGER.info("handling UnAssignLsminFromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignLsmin(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignT1ToPss2STEvent
   */
  @EventHandler(payloadType = AssignT1ToPss2STEvent.class)
  public void handle(AssignT1ToPss2STEvent event) {
    LOGGER.info("handling AssignT1ToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignT1(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignT1FromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignT1FromPss2STEvent.class)
  public void handle(UnAssignT1FromPss2STEvent event) {
    LOGGER.info("handling UnAssignT1FromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignT1(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignT10ToPss2STEvent
   */
  @EventHandler(payloadType = AssignT10ToPss2STEvent.class)
  public void handle(AssignT10ToPss2STEvent event) {
    LOGGER.info("handling AssignT10ToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignT10(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignT10FromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignT10FromPss2STEvent.class)
  public void handle(UnAssignT10FromPss2STEvent event) {
    LOGGER.info("handling UnAssignT10FromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignT10(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignT2ToPss2STEvent
   */
  @EventHandler(payloadType = AssignT2ToPss2STEvent.class)
  public void handle(AssignT2ToPss2STEvent event) {
    LOGGER.info("handling AssignT2ToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignT2(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignT2FromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignT2FromPss2STEvent.class)
  public void handle(UnAssignT2FromPss2STEvent event) {
    LOGGER.info("handling UnAssignT2FromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignT2(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignT3ToPss2STEvent
   */
  @EventHandler(payloadType = AssignT3ToPss2STEvent.class)
  public void handle(AssignT3ToPss2STEvent event) {
    LOGGER.info("handling AssignT3ToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignT3(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignT3FromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignT3FromPss2STEvent.class)
  public void handle(UnAssignT3FromPss2STEvent event) {
    LOGGER.info("handling UnAssignT3FromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignT3(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignT4ToPss2STEvent
   */
  @EventHandler(payloadType = AssignT4ToPss2STEvent.class)
  public void handle(AssignT4ToPss2STEvent event) {
    LOGGER.info("handling AssignT4ToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignT4(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignT4FromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignT4FromPss2STEvent.class)
  public void handle(UnAssignT4FromPss2STEvent event) {
    LOGGER.info("handling UnAssignT4FromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignT4(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignT5ToPss2STEvent
   */
  @EventHandler(payloadType = AssignT5ToPss2STEvent.class)
  public void handle(AssignT5ToPss2STEvent event) {
    LOGGER.info("handling AssignT5ToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignT5(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignT5FromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignT5FromPss2STEvent.class)
  public void handle(UnAssignT5FromPss2STEvent event) {
    LOGGER.info("handling UnAssignT5FromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignT5(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignT6ToPss2STEvent
   */
  @EventHandler(payloadType = AssignT6ToPss2STEvent.class)
  public void handle(AssignT6ToPss2STEvent event) {
    LOGGER.info("handling AssignT6ToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignT6(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignT6FromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignT6FromPss2STEvent.class)
  public void handle(UnAssignT6FromPss2STEvent event) {
    LOGGER.info("handling UnAssignT6FromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignT6(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignT7ToPss2STEvent
   */
  @EventHandler(payloadType = AssignT7ToPss2STEvent.class)
  public void handle(AssignT7ToPss2STEvent event) {
    LOGGER.info("handling AssignT7ToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignT7(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignT7FromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignT7FromPss2STEvent.class)
  public void handle(UnAssignT7FromPss2STEvent event) {
    LOGGER.info("handling UnAssignT7FromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignT7(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignT8ToPss2STEvent
   */
  @EventHandler(payloadType = AssignT8ToPss2STEvent.class)
  public void handle(AssignT8ToPss2STEvent event) {
    LOGGER.info("handling AssignT8ToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignT8(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignT8FromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignT8FromPss2STEvent.class)
  public void handle(UnAssignT8FromPss2STEvent event) {
    LOGGER.info("handling UnAssignT8FromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignT8(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignT9ToPss2STEvent
   */
  @EventHandler(payloadType = AssignT9ToPss2STEvent.class)
  public void handle(AssignT9ToPss2STEvent event) {
    LOGGER.info("handling AssignT9ToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignT9(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignT9FromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignT9FromPss2STEvent.class)
  public void handle(UnAssignT9FromPss2STEvent event) {
    LOGGER.info("handling UnAssignT9FromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignT9(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignVclToPss2STEvent
   */
  @EventHandler(payloadType = AssignVclToPss2STEvent.class)
  public void handle(AssignVclToPss2STEvent event) {
    LOGGER.info("handling AssignVclToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignVcl(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignVclFromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignVclFromPss2STEvent.class)
  public void handle(UnAssignVclFromPss2STEvent event) {
    LOGGER.info("handling UnAssignVclFromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignVcl(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event AssignVcuToPss2STEvent
   */
  @EventHandler(payloadType = AssignVcuToPss2STEvent.class)
  public void handle(AssignVcuToPss2STEvent event) {
    LOGGER.info("handling AssignVcuToPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss2ST entity = assignVcu(event.getPss2STId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /*
   * @param	event UnAssignVcuFromPss2STEvent
   */
  @EventHandler(payloadType = UnAssignVcuFromPss2STEvent.class)
  public void handle(UnAssignVcuFromPss2STEvent event) {
    LOGGER.info("handling UnAssignVcuFromPss2STEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss2ST entity = unAssignVcu(event.getPss2STId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss2ST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss2ST(entity);
  }

  /**
   * Method to retrieve the Pss2ST via an Pss2STPrimaryKey.
   *
   * @param id Long
   * @return Pss2ST
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public Pss2ST handle(FindPss2STQuery query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPss2STId());
  }

  /**
   * Method to retrieve a collection of all Pss2STs
   *
   * @param query FindAllPss2STQuery
   * @return List<Pss2ST>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<Pss2ST> handle(FindAllPss2STQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPss2ST, but only if the id matches
   *
   * @param entity Pss2ST
   */
  protected void emitFindPss2ST(Pss2ST entity) {
    LOGGER.info("handling emitFindPss2ST");

    queryUpdateEmitter.emit(
        FindPss2STQuery.class,
        query -> query.getFilter().getPss2STId().equals(entity.getPss2STId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPss2ST
   *
   * @param entity Pss2ST
   */
  protected void emitFindAllPss2ST(Pss2ST entity) {
    LOGGER.info("handling emitFindAllPss2ST");

    queryUpdateEmitter.emit(FindAllPss2STQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(Pss2STProjector.class.getName());
}
