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
 * Inductance business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Inductance related services in the case of a Inductance business
 *       related service failing.
 *   <li>Exposes a simpler, uniform Inductance interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Inductance business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class InductanceBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public InductanceBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Inductance Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return InductanceBusinessDelegate
   */
  public static InductanceBusinessDelegate getInductanceInstance() {
    return (new InductanceBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createInductance(CreateInductanceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getInductanceId() == null) command.setInductanceId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      InductanceValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateInductanceCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateInductanceCommand of Inductance is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Inductance - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateInductanceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateInductance(UpdateInductanceCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      InductanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateInductanceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Inductance - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteInductanceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteInductanceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      InductanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteInductanceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Inductance using Id = " + command.getInductanceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Inductance via InductanceFetchOneSummary
   *
   * @param summary InductanceFetchOneSummary
   * @return InductanceFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Inductance getInductance(InductanceFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("InductanceFetchOneSummary arg cannot be null");

    Inductance entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      InductanceValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Inductance
      // --------------------------------------
      CompletableFuture<Inductance> futureEntity =
          queryGateway.query(
              new FindInductanceQuery(new LoadInductanceFilter(summary.getInductanceId())),
              ResponseTypes.instanceOf(Inductance.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Inductance with id " + summary.getInductanceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Inductances
   *
   * @return List<Inductance>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Inductance> getAllInductance() throws ProcessingException {
    List<Inductance> list = null;

    try {
      CompletableFuture<List<Inductance>> futureList =
          queryGateway.query(
              new FindAllInductanceQuery(), ResponseTypes.multipleInstancesOf(Inductance.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Inductance";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on Inductance
   *
   * @param command AssignValueToInductanceCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToInductanceCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getInductanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FloatProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FloatProxyBusinessDelegate.getFloatProxyInstance();
    InductanceBusinessDelegate parentDelegate = InductanceBusinessDelegate.getInductanceInstance();
    UUID childId = command.getAssignment().getFloatProxyId();
    FloatProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      InductanceValidator.getInstance().validate(command);

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
   * unAssign Value on Inductance
   *
   * @param command UnAssignValueFromInductanceCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromInductanceCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      InductanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on Inductance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Inductance
   */
  private Inductance load(UUID id) throws ProcessingException {
    inductance =
        InductanceBusinessDelegate.getInductanceInstance()
            .getInductance(new InductanceFetchOneSummary(id));
    return inductance;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Inductance inductance = null;
  private static final Logger LOGGER = Logger.getLogger(InductanceBusinessDelegate.class.getName());
}
