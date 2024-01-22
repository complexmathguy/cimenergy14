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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * Conductance business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Conductance related services in the case of a Conductance
 *       business related service failing.
 *   <li>Exposes a simpler, uniform Conductance interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Conductance business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ConductanceBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ConductanceBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Conductance Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ConductanceBusinessDelegate
   */
  public static ConductanceBusinessDelegate getConductanceInstance() {
    return (new ConductanceBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createConductance(CreateConductanceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getConductanceId() == null) command.setConductanceId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConductanceValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateConductanceCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateConductanceCommand of Conductance is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Conductance - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateConductanceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateConductance(UpdateConductanceCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ConductanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateConductanceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Conductance - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteConductanceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteConductanceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConductanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteConductanceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Conductance using Id = " + command.getConductanceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Conductance via ConductanceFetchOneSummary
   *
   * @param summary ConductanceFetchOneSummary
   * @return ConductanceFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Conductance getConductance(ConductanceFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ConductanceFetchOneSummary arg cannot be null");

    Conductance entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ConductanceValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Conductance
      // --------------------------------------
      CompletableFuture<Conductance> futureEntity =
          queryGateway.query(
              new FindConductanceQuery(new LoadConductanceFilter(summary.getConductanceId())),
              ResponseTypes.instanceOf(Conductance.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Conductance with id " + summary.getConductanceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Conductances
   *
   * @return List<Conductance>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Conductance> getAllConductance() throws ProcessingException {
    List<Conductance> list = null;

    try {
      CompletableFuture<List<Conductance>> futureList =
          queryGateway.query(
              new FindAllConductanceQuery(), ResponseTypes.multipleInstancesOf(Conductance.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Conductance";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on Conductance
   *
   * @param command AssignValueToConductanceCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToConductanceCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getConductanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FloatProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FloatProxyBusinessDelegate.getFloatProxyInstance();
    ConductanceBusinessDelegate parentDelegate =
        ConductanceBusinessDelegate.getConductanceInstance();
    UUID childId = command.getAssignment().getFloatProxyId();
    FloatProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ConductanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get FloatProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Value on Conductance
   *
   * @param command UnAssignValueFromConductanceCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromConductanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConductanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on Conductance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Conductance
   */
  private Conductance load(UUID id) throws ProcessingException {
    conductance =
        ConductanceBusinessDelegate.getConductanceInstance()
            .getConductance(new ConductanceFetchOneSummary(id));
    return conductance;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Conductance conductance = null;
  private static final Logger LOGGER =
      Logger.getLogger(ConductanceBusinessDelegate.class.getName());
}
